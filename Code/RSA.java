package 密码学;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

import javax.crypto.SecretKey;
import javax.swing.*;

//实现接口ActionListener
public class RSA implements ActionListener {

	private static final SecretKey SecretKey = null;
	JFrame jf;
	JPanel jpanel;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
	JTextArea jta = null;
	JScrollPane jscrollPane;
	int miyaoMark = 0;
	SecretKey Key = null;// 密钥
	BigInteger p = CreateBigPrime.getPrime(20); // 获得大素数p
	BigInteger q = CreateBigPrime.getPrime(20); // 获得大素数q
	BigInteger jiamie = new BigInteger("0");
	String strp = null;
	String strq = null;
	String connect = null;
	String Info = null;
	String path_encrypt = null;
	String path_decrypt = null;

	public RSA() {

		jf = new JFrame("RSA");
		Color c = new Color(24, 102, 134);
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());

		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setFont(new Font("宋体", Font.BOLD, 16));
		jta.setForeground(Color.white);
		jta.setLineWrap(true);// 激活自动换行功能
		jta.setWrapStyleWord(true);// 激活断行不断字功能
		jta.setBackground(c);
		jta.setEditable(false);

		jscrollPane = new JScrollPane(jta);
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 5));

		jb5 = new JButton("加密路径");
		jb5.setBackground(c);
		jb5.setForeground(Color.white); 
		jb5.addActionListener(this);
		
		jb1 = new JButton("开始加密");
		jb1.setBackground(c);
		jb1.setForeground(Color.white); 
		jb1.addActionListener(this);
		
		jb2 = new JButton("解密路径");
		jb2.setBackground(c);
		jb2.setForeground(Color.white); 
		jb2.addActionListener(this);
		
		jb3 = new JButton("生成密钥");
		jb3.setBackground(c);
		jb3.setForeground(Color.white); 
		jb3.addActionListener(this);
		
		jb7 = new JButton("输入e");
		jb7.setBackground(c);
		jb7.setForeground(Color.white); 
		jb7.addActionListener(this);
		
		jb6 = new JButton("显示密钥");
		jb6.setBackground(c);
		jb6.setForeground(Color.white); 
		jb6.addActionListener(this);
		
		jb4 = new JButton("解密文件");
		jb4.setBackground(c);
		jb4.setForeground(Color.white); 
		jb4.addActionListener(this);

		jpanel.add(jb3);
		jpanel.add(jb6);
		jpanel.add(jb7);
		jpanel.add(jb5);
		jpanel.add(jb1);
		jpanel.add(jb2);
		jpanel.add(jb4);
		
		contentPane.add(jscrollPane, BorderLayout.CENTER);
		contentPane.add(jpanel, BorderLayout.SOUTH);

		jf.setSize(800, 500);
		jf.setLocation(400, 200);
		jf.setVisible(true);
	}
	BigInteger p1 = new BigInteger("297707"); // 获得大素数p
	BigInteger q1 = new BigInteger("513277"); // 获得大素数q
	// 覆盖接口ActionListener的方法actionPerformed
	public void actionPerformed(ActionEvent e){
		RSA_new jiami = new RSA_new(p1,q1,jiamie);// 新建DES加密对象
		if (e.getSource() == jb1) {
			// jta.copy();
//			if (Info == null) {
//				JOptionPane.showMessageDialog(null, "请输入信息", "禁止操作", 0, null);
//			} else 
//				if (miyaoMark == 0) {
//				JOptionPane.showMessageDialog(null, "请生成密钥", "禁止操作", 0, null);
//			} else {
				
				BufferedInputStream bfs;
				BufferedWriter bw;
				try {
					bfs = new BufferedInputStream(new FileInputStream(path_encrypt));
					bw = new BufferedWriter(new FileWriter("temp.txt"));
					
					int b = 0;
					int c = 0;

					int count = 0;
					while ((b = bfs.read()) != -1) {


						String b_string = String.valueOf(b); // 
						BigInteger big = new BigInteger(b_string);  

						BigInteger output = jiami.encrypt(big, jiami.getKeys()); //密文
						String str_out = output.toString();
						
						bw.write(str_out);
						bw.newLine();
					}
					bfs.close();	
					bw.close();	
				} catch (IOException e1) {
					e1.printStackTrace();
				} 

				Info = null;
			}
//		}
	 
			else if (e.getSource() == jb2) {
				
				JFileChooser jfc=new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				jfc.showDialog(new JLabel(), "选择");
				File file=jfc.getSelectedFile();
				
//				if(file.isDirectory()){
//					//System.out.println("文件夹:"+file.getAbsolutePath());
//				}else if(file.isFile()){
//					System.out.println("文件:"+file.getAbsolutePath());
//				}
//				System.out.println(jfc.getSelectedFile().getName());

				path_decrypt = file.getAbsolutePath();
				jta.append("解密路径：\n" + path_decrypt+"\n");
			
		} 
		else if (e.getSource() == jb3) {		
			strp = p.toString();
			strq = q.toString();

//			connect = "p:"+strp + "     "+"q:"+strq;
			
			connect = "p:"+"297707" + "     "+"q:"+"513277";
			miyaoMark = 1;
//			JOptionPane.showMessageDialog(null,strp+strq , "ok", 2, null);
			JOptionPane.showMessageDialog(null,"297707513277" , "ok", 2, null);
		}
	else if (e.getSource() == jb5) {
			
				JFileChooser jfc=new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				jfc.showDialog(new JLabel(), "选择");
				File file=jfc.getSelectedFile();
				
//				if(file.isDirectory()){
//					//System.out.println("文件夹:"+file.getAbsolutePath());
//				}else if(file.isFile()){
//					System.out.println("文件:"+file.getAbsolutePath());
//				}
//				System.out.println(jfc.getSelectedFile().getName());

			path_encrypt = file.getAbsolutePath();
			jta.append("加密路径：\n" + path_encrypt+"\n");
			
		} 
	else if (e.getSource() == jb4) {
		BufferedReader br;
		BufferedOutputStream bw0;
		BufferedInputStream bf;
		try {
			br = new BufferedReader(new FileReader(path_decrypt));  // 解密文件
			bw0 = new BufferedOutputStream(new FileOutputStream("decrypt_file"));  // 解密文件
		//	bf = new BufferedInputStream(new FileInputStream(path_decrypt));
			String a;
			while((a = br.readLine()) != null)
			{
			BigInteger big0 = new BigInteger(a);  

			
			BigInteger de_output = jiami.decrypt(big0, jiami.getKeys());
			int de_output_int = de_output.intValue();
			System.out.println(de_output_int);
			bw0.write(de_output_int);
			}
			br.close();
	//	bf.close();
			bw0.close();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		}
	else if (e.getSource() == jb6) {
			jta.append("\n"+"RSA秘钥：" + connect + "\n");
		}
		else if(e.getSource() == jb7) {
//			if (Info == null) {
//				JOptionPane.showMessageDialog(null, "请输入e的值", "禁止操作", 0, null);
//			} 
//			
//				
//			else {
			BigInteger ff = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));	//求解ff（n）（p-1）*（q-1）			
			while (((GCD.gcd(ff, jiamie)).compareTo(BigInteger.ONE))!=0 ) {	//判断e的值是否与ff（n）互素
				String tem = JOptionPane.showInputDialog("请输入e的值");
//				String tempe = jta.getText();
				jta.append("\n"+"e的值: " + tem+"\n");
				jiamie = new BigInteger(tem);	
			}
			
	
//			}
		}
	}

	/**
	 * 加密方法
	 */
	public static String generEn(String content) {

		return content;
	}

	/**
	 * 解密方法
	 */
	public static String generDc(String content) {

		return content;
	}
}
