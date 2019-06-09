package 密码学;

import java.math.BigInteger;
//rsa
public class RSA_new {
	private BigInteger[][] keys;                        
    private BigInteger e = new BigInteger("0") ;
    private BigInteger p = new BigInteger("0");
	private BigInteger q = new BigInteger("0");
    
	public RSA_new(BigInteger p,BigInteger q,BigInteger e) {
		super();
		this.e = e;
		this.p = p;
		this.q = q;
		this.keys = two_genkey.genKey(p, q, e); // 调用two_genkey()生成公私钥
	}
	public BigInteger[][] getKeys() {
		return keys;
	}
	
	//加密
	public BigInteger encrypt(BigInteger m, BigInteger[][] keys){
		BigInteger n = keys[0][0] ;
		BigInteger e = keys[0][1] ;
	    
		BigInteger c = new Exponentiation().expMode(m, e, n) ; // 计算出密文c
	    return c ; 
	}
	
	//解密
	public BigInteger decrypt(BigInteger c, BigInteger[][] keys){
		BigInteger n = keys[1][0] ;
		BigInteger d = keys[1][1] ;
		
		BigInteger m = new Exponentiation().expMode(c, d, n); //解密密文c
		return m ;//
	}
	
}

