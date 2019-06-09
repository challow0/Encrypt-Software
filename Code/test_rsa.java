package 密码学;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

//import bianma.RSA_new;

public class test_rsa {

	public static void main(String[] args) throws IOException {
		GCD x = new GCD();
		Scanner input = new Scanner(System.in);
		System.out.println("输入密钥的位数");
		int bit = input.nextInt();

		BigInteger p = CreateBigPrime.getPrime(bit);  // 获得大素数p
		BigInteger q = CreateBigPrime.getPrime(bit);	// 获得大素数q
		BigInteger ff = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));	//求解ff（n）（p-1）*（q-1）
		BigInteger e = new BigInteger("0");  // 初始化0
		System.out.println("p是：" + p);		//p
		System.out.println("q是：" + q);	

		while (((x.gcd(ff, e)).compareTo(BigInteger.ONE))!=0 ) {	//判断e的值是否与ff（n）互素
			System.out.println("请输入e的值");	
			int int_e = input.nextInt();
			String str = String.valueOf(int_e);
			e = new BigInteger(str);

		}
		
		RSA_new rsa_input = new RSA_new(p, q, e); // (p, q, e)
		BufferedInputStream bfs = new BufferedInputStream(new FileInputStream("2.jpg")); // 读取的文件

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("in_decrypt_2.jpg")); // 解密后的文件
		BufferedOutputStream eos = new BufferedOutputStream(new FileOutputStream("in_encrypt.txt")); //加密后的文件

		BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));
		
		int b = 0;
	//	int c = 0;

//		int count = 0;
		while ((b = bfs.read()) != -1) {


			String b_string = String.valueOf(b); // 
			BigInteger big = new BigInteger(b_string); // 

			// rsa_input.encrypt(big, rsa_input.getPubkey());
			BigInteger output = rsa_input.encrypt(big, rsa_input.getKeys()); //密文

			BigInteger de_output = rsa_input.decrypt(output, rsa_input.getKeys());//密文解密 

			BigInteger mood = new BigInteger("255");
			BigInteger output_mod = output.mod(mood);
			 int little_out = output_mod.intValue();
			 
//			String str_out = output.toString();
			System.out.println(output); 
			
			eos.write(little_out);
			int de_output_int = de_output.intValue();
			bos.write(de_output_int);


		}
		eos.close();
		bos.close();
		bfs.close();		
		

	}

}
