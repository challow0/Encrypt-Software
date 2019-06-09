package 密码学;
import java.math.BigInteger;

/**
 * �����Լ��
 * @author ���Ŵ����
 *
 */
public class GCD {
	/**
	 * <p>շת����������Լ��
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigInteger gcd(BigInteger a, BigInteger b){
		if(b.equals(BigInteger.ZERO)){
			return a ;
		}else{
			return gcd(b, a.mod(b)) ;
		}
	}
	/**
	 * <p>��ax + by = 1�е�x��y�������⣨a��b���ʣ�
	 * @param a
	 * @param b
	 * @return
	 */
	public BigInteger[] extGcd(BigInteger a, BigInteger b){
		if(b.equals(BigInteger.ZERO)){
			BigInteger x1 = BigInteger.ONE ;
			BigInteger y1 = BigInteger.ZERO ;
			BigInteger x = x1 ;
			BigInteger y = y1 ;
			BigInteger r = a ;
			BigInteger[] result = {r, x, y} ;
	        return result ;
		}else{
			BigInteger[] temp = extGcd(b, a.mod(b)) ; //a.mod(b)a��bȡ��
			BigInteger r  = temp[0] ;
			BigInteger x1 = temp[1] ;
			BigInteger y1 = temp[2] ;
			
			BigInteger x = y1 ;
			BigInteger y = x1.subtract(a.divide(b).multiply(y1)) ;
			BigInteger[] result = {r, x, y} ;
	        return result ;
		}
	} 
}
