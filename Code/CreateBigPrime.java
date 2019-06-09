package 密码学;
 
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
 
/**
 *
 * @author steven
 */
public class CreateBigPrime {
 
    private static Random ran = null;
 
    static {
        ran = new SecureRandom();
    }
 
    /**
     * ���� base^exp % n
     *
     * @param base
     * @param exp
     * @param n
     * @return
     */
    public static BigInteger expmod(int base, BigInteger exp, BigInteger n) {
        if (exp.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
 
        if (!exp.testBit(0)) {
            return expmod(base, exp.divide(BigInteger.valueOf(2)), n).pow(2).remainder(n);
        } else {
            return (expmod(base, exp.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2)), n).pow(2).multiply(BigInteger.valueOf(base))).remainder(n);
        }
    }
 
    /**
     * 费马测试
     *
     *基于费马素性检测
		假如a是整数，p是质数，且a,p互质(即两者只有一个公约数1)，那么a的(p-1)次方除以p的余数恒等于1。
		也就是说, 如果p为素数, 那么对于任何a<p, 有
		a ^ p % p == a   成立
		而它的逆命题则至少有1/2的概率成立
		那么我们就可以通过多次素性检测, 来减少假素数出现的概率
		而素数定理, 又指出了素数的密度与ln(x)成反比, 也就是说, 我们可以先随机生成一个n bit的整数, 如果不是素数, 则继续向后取, 那么, 大概取n个数, 就能碰到一个素数
     * @param n
     * @return
     */
    public static boolean fermatTest(BigInteger n) {
        int base = 0;
        if (n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) < 0) {
            base = ran.nextInt(n.intValue() - 1) + 1;
        } else {
            base = ran.nextInt(Integer.MAX_VALUE - 1) + 1;
        }
        if (expmod(base, n, n).equals(BigInteger.valueOf(base))) {
            return true;
        } else {
            return false;
        }
    }
 
    /**
     * Miller-Rabin算法
     *
     * @param n
     * @return
     */
    public static boolean passesMillerRabin(BigInteger n) {
        int base = 0;
        if (n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) < 0) {
            base = ran.nextInt(n.intValue() - 1) + 1;
        } else {
            base = ran.nextInt(Integer.MAX_VALUE - 1) + 1;
        }
 
        BigInteger thisMinusOne = n.subtract(BigInteger.ONE);
        BigInteger m = thisMinusOne;
        while (!m.testBit(0)) {
            m = m.shiftRight(1);
            BigInteger z = expmod(base, m, n);
            if (z.equals(thisMinusOne)) {
                break;
            } else if (z.equals(BigInteger.ONE)) {
 
            } else {
                return false;
            }
        }
        return true;
    }
 
    public static boolean isPrime(BigInteger n) {
    	
        //检验次数的多少与n的大小有关，n越大需要检测的次数越少
        int sizeInBits = n.bitLength(); // 
        int tryTime = 0;
        if (sizeInBits < 100) {
            tryTime = 50;
        }
 
        if (sizeInBits < 256) {
            tryTime = 27;
        } else if (sizeInBits < 512) {
            tryTime = 15;
        } else if (sizeInBits < 768) {
            tryTime = 8;
        } else if (sizeInBits < 1024) {
            tryTime = 4;
        } else {
            tryTime = 2;
        }
        return isPrime(n, tryTime);
    }
 
    /**
     *
     * @param n
     * @param tryTime
     * @return
     */
    public static boolean isPrime(BigInteger n, int tryTime) {  
        for (int i = 0; i < tryTime; i++) {
            if (!passesMillerRabin(n)) {  // MillerRabin
                return false;
            }
        }
        return true;
    }
 
    /**
     *
     *
     * @param bitCount
     * @return
     */
    public static BigInteger getPrime(int bitCount) {
        BigInteger init = new BigInteger(bitCount, ran);
        if (!init.testBit(0)) {
            init = init.setBit(0);
        }
        int i = 0;
        while (!isPrime(init)) {
            i++;
            init = init.add(BigInteger.valueOf(2));
        }
        //System.out.println(String.format("try %d\ttimes", i));
        return init;
    }
    public static void main(String []args) {
    	BigInteger b = new BigInteger("123");
    	b = getPrime(20);
    	System.out.println(b);
    	
    }
}