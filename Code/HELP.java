package 密码学;


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
public class HELP implements ActionListener {

 JFrame jf;
 JPanel jpanel;
 JButton jb1, jb2, jb3;
 JTextArea jta = null;
 JScrollPane jscrollPane;
 JLabel nameJLabel1,nameJLabel2,nameJLabel3,nameJLabel4,nameJLabel5,nameJLabel6,nameJLabel7,nameJLabel8,nameJLabel9;
 int zhuan=1;
public HELP() {

  jf = new JFrame("说明");
  jf.setResizable(false);//固定大小
  Container contentPane = jf.getContentPane();
  contentPane.setLayout(new BorderLayout());

	 nameJLabel1=new JLabel();
	 nameJLabel1.setBounds(0,0,600,350);
	 nameJLabel1.setIcon(new ImageIcon("帮助.png"));
	 jf.add(nameJLabel1);
	 
	 nameJLabel2=new JLabel();
	 nameJLabel2.setBounds(0,0,500,250);
	 nameJLabel2.setIcon(new ImageIcon("help2.jpg"));
	 nameJLabel2.setVisible(false);
	 jf.add(nameJLabel2);
	 nameJLabel3=new JLabel();
	 nameJLabel3.setBounds(0,0,500,250);
	 nameJLabel3.setIcon(new ImageIcon("help3.jpg"));
	 nameJLabel3.setVisible(false);
	 jf.add(nameJLabel3);
	 nameJLabel4=new JLabel();
	 nameJLabel4.setBounds(0,0,500,250);
	 nameJLabel4.setIcon(new ImageIcon("help4.jpg"));
	 nameJLabel4.setVisible(false);
	 jf.add(nameJLabel4);
	 nameJLabel5=new JLabel();
	 nameJLabel5.setBounds(0,0,500,250);
	 nameJLabel5.setIcon(new ImageIcon("help5.jpg"));
	 nameJLabel5.setVisible(false);
	 jf.add(nameJLabel5);
	 nameJLabel6=new JLabel();
	 nameJLabel6.setBounds(0,0,500,250);
	 nameJLabel6.setIcon(new ImageIcon("help6.jpg"));
	 nameJLabel6.setVisible(false);
	 jf.add(nameJLabel6);
	 nameJLabel7=new JLabel();
	 nameJLabel7.setBounds(0,0,500,250);
	 nameJLabel7.setIcon(new ImageIcon("help7.jpg"));
	 nameJLabel7.setVisible(false);
	 jf.add(nameJLabel7);
	 nameJLabel8=new JLabel();
	 nameJLabel8.setBounds(0,0,500,250);
	 nameJLabel8.setIcon(new ImageIcon("help8.jpg"));
	 nameJLabel8.setVisible(false);
	 jf.add(nameJLabel8);
	 nameJLabel9=new JLabel();
	 nameJLabel9.setBounds(0,0,500,250);
	 nameJLabel9.setIcon(new ImageIcon("help9.jpg"));
	 nameJLabel9.setVisible(false);
	 jf.add(nameJLabel9);


  jscrollPane = new JScrollPane(jta);
  jpanel = new JPanel();
  jpanel.setLayout(new GridLayout(1, 3));

  jb1 = new JButton("上一张");
  jb1.addActionListener(this);
  jb2 = new JButton("下一张");
  jb2.addActionListener(this);

//  jpanel.add(jb1);
//  jpanel.add(jb2);
  contentPane.add(jscrollPane, BorderLayout.CENTER);
  contentPane.add(jpanel, BorderLayout.SOUTH);

  jf.setSize(600, 350);
  jf.setLocation(400, 200);
  jf.setVisible(true);
 }

// 覆盖接口ActionListener的方法actionPerformed
 public void actionPerformed(ActionEvent e) {
     if (e.getSource() == jb1) {
        	 if(zhuan==1){
        		 JOptionPane.showMessageDialog(null, "这是第一张", "禁止", JOptionPane.ERROR_MESSAGE);
        	 }else{
        		 //nameJLabel1.setVisible(false);
        		 //nameJLabel2.setVisible(true);
        		 zhuan--;
        		 switch(zhuan){
        		 case 1:	
        			 nameJLabel1.setVisible(true);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 2:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(true);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 3:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(true);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 4:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(true);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 5:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(true);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 6:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(true);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 7:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(true);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 8:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(true);
    			     nameJLabel9.setVisible(false);
    			     break;
        		 case 9:	
        			 nameJLabel1.setVisible(false);
    			     nameJLabel2.setVisible(false);
    			     nameJLabel3.setVisible(false);
    			     nameJLabel4.setVisible(false);
    			     nameJLabel5.setVisible(false);
    			     nameJLabel6.setVisible(false);
    			     nameJLabel7.setVisible(false);
    			     nameJLabel8.setVisible(false);
    			     nameJLabel9.setVisible(true);
    			     break;
        		 }
        	 }
     } else if (e.getSource() == jb2) {
    	 if(zhuan==9){
    		 JOptionPane.showMessageDialog(null, "这是最后一张", "禁止", JOptionPane.ERROR_MESSAGE);
    	 }else{
    		 //nameJLabel1.setVisible(false);
    		 //nameJLabel2.setVisible(true);
    		 zhuan++;
    		 switch(zhuan){
    		 case 1:	
    			 nameJLabel1.setVisible(true);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 2:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(true);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 3:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(true);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 4:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(true);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 5:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(true);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 6:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(true);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 7:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(true);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 8:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(true);
			     nameJLabel9.setVisible(false);
			     break;
    		 case 9:	
    			 nameJLabel1.setVisible(false);
			     nameJLabel2.setVisible(false);
			     nameJLabel3.setVisible(false);
			     nameJLabel4.setVisible(false);
			     nameJLabel5.setVisible(false);
			     nameJLabel6.setVisible(false);
			     nameJLabel7.setVisible(false);
			     nameJLabel8.setVisible(false);
			     nameJLabel9.setVisible(true);
			     break;
    		 }
    	 }
    }
 }
}
