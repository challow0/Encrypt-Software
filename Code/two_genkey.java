package 密码学;

import java.math.BigInteger;

public class two_genkey {
	
	public static BigInteger[][] genKey(BigInteger p, BigInteger q, BigInteger e){
		BigInteger n = p.multiply(q); //  n = p * q
		BigInteger ff = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)) ; // ff(n) = (p - 1) * (q - 1)
			//BigInteger e = new BigInteger("3889") ;
		//BigInteger e = new BigInteger("11") ;
			// generate d
//		BigInteger a = e ;
//		BigInteger b = ff ;
		BigInteger[] rxy = new GCD().extGcd(e, ff);  //  
		BigInteger r = rxy[0] ;
		BigInteger x = rxy[1] ;
		BigInteger y = rxy[2] ;
		
		BigInteger d = x ;  
	
		return new BigInteger[][]{{n , e}, {n , d}} ; // n e 是公钥   d是私钥揭秘使用
	}
}
