package 密码学;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.crypto.SecretKey;
import javax.swing.*;

//实现接口ActionListener
public class DES2 implements ActionListener {

	JFrame jf;
	JPanel jpanel;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JTextArea jta = null;
	JScrollPane jscrollPane;
	int miyaoMark = 0;
	SecretKey Key = null;// 密钥
	String Info = null;
	
    String origin = " ";
	
	
    String plaintext = " ";
    String ciphertext = " ";
    String key = " ";
    byte[] c ;
    
	public DES2() {

		jf = new JFrame("DES");
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
        Color c = new Color(24, 102, 134);

		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setFont(new Font("标楷体", Font.BOLD, 16));
		jta.setForeground(Color.white);
		jta.setLineWrap(true);// 激活自动换行功能
		jta.setWrapStyleWord(true);// 激活断行不断字功能
		jta.setBackground(c);
		jta.setEditable(false);

		jscrollPane = new JScrollPane(jta);
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 5));

		jb5 = new JButton("输入信息");
		jb5.setBackground(c);
		jb5.setForeground(Color.white); 
		jb5.addActionListener(this);
		
		jb1 = new JButton("开始加密");
		jb1.setBackground(c);
		jb1.setForeground(Color.white); 

		jb1.addActionListener(this);
		
		jb2 = new JButton("开始解密");
		jb2.setBackground(c);
		jb2.setForeground(Color.white); 

		jb2.addActionListener(this);
		
		jb3 = new JButton("生成密钥");
		jb3.setBackground(c);
		jb3.setForeground(Color.white); 

		jb3.addActionListener(this);
		
		jb6 = new JButton("显示密钥");
		jb6.setBackground(c);
		jb6.setForeground(Color.white); 

		jb6.addActionListener(this);
		
		jb4 = new JButton("保存");
		jb4.setBackground(c);
		jb4.setForeground(Color.white); 

		jb4.addActionListener(this);

		jpanel.add(jb5);		
		jpanel.add(jb1);
		jpanel.add(jb2);
		jpanel.add(jb3);
		jpanel.add(jb6);
		jpanel.add(jb4);

		contentPane.add(jscrollPane, BorderLayout.CENTER);
		contentPane.add(jpanel, BorderLayout.SOUTH);

		jf.setSize(600, 400);
		jf.setLocation(400, 200);
		jf.setVisible(true);
	}

	// 覆盖接口ActionListener的方法actionPerformed
	public void actionPerformed(ActionEvent e) {
		DESreal jiami = new DESreal();// 新建DES加密对象
        DESreal des = new DESreal();
     // CustomDES customDES=new CustomDES(key,origin);
                
        
		if (e.getSource() == jb1) {
			// jta.copy();
			if (Info == null) {
				JOptionPane.showMessageDialog(null, "请输入信息", "禁止操作", 0, null);
			} else if (miyaoMark == 0) {
				JOptionPane.showMessageDialog(null, "请生成密钥", "禁止操作", 0, null);
			} else {
				jta.append("\n" + "加密后信息：\n");
		        ciphertext = des.encrypt(plaintext, key, "encrypt");
		        
//		        c = customDES.deal(origin.getBytes(),1);		        
//				String encrypt = new String(c);	
//				jta.append(encrypt);
				jta.append( ciphertext + "\n");
				Info = null;
			}
		} else if (e.getSource() == jb2) {
			// jta.paste();
			if (Info == null) {
				JOptionPane.showMessageDialog(null, "请输入信息", "禁止操作", 0, null);
			} else {
				jta.append("\n" + "解密后信息：\n");
//		        c = customDES.deal(origin.getBytes(),1);
//		        byte[]p=customDES.deal(c,0);
//		        byte[] p_d=new byte[origin.getBytes().length];
//		        System.arraycopy(p,0,p_d,0,origin.getBytes().length);
				
				
				
				String output = des.encrypt(ciphertext, key, "decrypt");
				jta.append( new String(output) + "\n");
				Info = null;
			}
		} else if (e.getSource() == jb3) {  // 生成密钥
			String xxx = JOptionPane.showInputDialog("请输入密钥");
			miyaoMark = 1;
			
			key = xxx;
		
			
		} else if (e.getSource() == jb5) {
			Info = JOptionPane.showInputDialog("请输入信息(不超过7个字符)");
			if (Info != null) {
				
//				origin = Info;
				
				plaintext = Info;				
				jta.append("原信息：\n" + Info);
			}
		} else if (e.getSource() == jb4) {
			String[] linestring = jta.getText().split("\n");// 先获取文本框中的信息
			int intx = 0;
			// StringBuffer con= new StringBuffer();
			for (String name : linestring) {
				// con.append(name);
				save(name);// 读一行，追加一行
				intx++;
			}
			File file = new File("MD5加密信息.txt");
			if (file.exists()) {
				JOptionPane.showMessageDialog(null, "成功保存在当前工程的根目录下(注意不要重复保存，文件拷贝值后删除)", "OK", 2, null);
			}
		} else if (e.getSource() == jb6) {
			jta.append("DES秘钥：" + key + "\n");
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

	/**
	 * 文件保存方法
	 */
	public static void save(String content) {
		try {
			String data = content;

			File file = new File("DES2加密信息.txt");

			// 文件不存在的话，就进行创建
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			FileWriter fileWritter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
