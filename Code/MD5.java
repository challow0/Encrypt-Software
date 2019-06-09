package 密码学;

/**
 * @param MD5加密算法
 * @param Algorithm
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

//实现接口ActionListener
public class MD5 implements ActionListener {

	JFrame jf;
	JPanel jpanel;
	JButton jb1, jb2, jb3,jb4;  //创建按键
	JTextArea jta = null;  //文本输入框
	JScrollPane jscrollPane;  //滚动条（配合JTextArea使用）

	public MD5() {  //图形界面

		jf = new JFrame("MD5加密");  // 标题栏
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
        Color c = new Color(24, 102, 134);
		
		//文本输入框
		jta = new JTextArea(10, 15);  
		jta.setTabSize(4);
		jta.setFont(new Font("标楷体", Font.BOLD, 16));  //输入字体样式
		jta.setLineWrap(true);// 激活自动换行功能
		jta.setWrapStyleWord(true);// 激活断行不断字功能
		jta.setForeground(Color.white);  // 更改输入字体颜色
		jta.setBackground(c);  //背景颜色
		
		//滚动条设置
		jscrollPane = new JScrollPane(jta);
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 3));

		//按键的设置
		jb1 = new JButton("MD5加密");
		jb1.setBackground(c);
		jb1.setForeground(Color.white); 
		jb1.setBounds(300,200, 160, 50);
		jb1.addActionListener(this);
		jb2 = new JButton("MD5解密");
		jb2.setBackground(c);
		jb2.setForeground(Color.white);
		jb2.addActionListener(this);
		jb3 = new JButton("保存");
		jb3.setBackground(c);
		jb3.setForeground(Color.white);
		jb3.addActionListener(this);
		jb4 = new JButton("test");
		jb4.setBackground(c);
		jb4.setForeground(Color.white);
		jb4.addActionListener(this);
			
		jpanel.add(jb1);
		jpanel.add(jb2);
		jpanel.add(jb3);
		contentPane.add(jscrollPane, BorderLayout.CENTER);
		contentPane.add(jpanel, BorderLayout.SOUTH);

		jf.setSize(600, 400);  //弹出窗口大小
		jf.setLocation(400, 200);  //生成窗口位置
		jf.setVisible(true); //确定窗口参数设置完毕，初始化窗口
	}

	// 覆盖接口ActionListener的方法actionPerformed
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {  // 按下button1
			// jta.copy();
			String[] linestring = jta.getText().split("\n");  // 按行读取输入文字的内容
			int intx = 0;
			int temp = 0;
			for (String name : linestring) {
				if (name.isEmpty()) {  
					//JOptionPane.showMessageDialog(null, "请输入信息", "警告", JOptionPane.ERROR_MESSAGE);  // 提示框
					break;
				} else {
					if (temp == 0) {
						jta.append("\n" + "加密后信息：\n");
					}
					jta.append(string2MD5(name));
					intx++;
				}
			}
		} else if (e.getSource() == jb2) { // 按下button2 
			// jta.paste();
			JOptionPane.showMessageDialog(null, "MD5加密算法不可逆，不能够进行信息解密", "不可逆警告", JOptionPane.ERROR_MESSAGE);
		} else if (e.getSource() == jb3) {  //按下button3
			String[] linestring = jta.getText().split("\n");// 先获取文本框中的信息
			int intx = 0;
			int mark = 0;
			// StringBuffer con= new StringBuffer();
			for (String name : linestring) {
				// con.append(name);
				if (name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "未输入信息", "警告", JOptionPane.ERROR_MESSAGE);
					mark = 1;
					break;
				} else {
					save(name);// 读一行，追加一行
					intx++;
				}
			}
			if (mark == 0) {
				File file = new File("MD5加密信息.txt");  //生成加密后的信息文件
				if (file.exists()) {
					JOptionPane.showMessageDialog(null, "成功保存在当前工程的根目录下(注意不要重复保存，文件拷贝值后删除)", "OK", 2, null);
				}
			}
		}
	}

	/***
	 * MD5加码 生成32位md5码
	 */
	public static String string2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * 文件保存方法
	 */
	public static void save(String content) {
		try {
			String data = content;

			File file = new File("MD5加密信息.txt");

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
