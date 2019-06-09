package 密码学;
/**
 * @author Orange
 * @param 主界面
 * 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; 

public class Login extends JFrame
{
       private JComboBox nameJComboBox;  // 下拉组件
       private JPanel userJPanel;
       private JLabel pictureJLabel,JLabel1,mimalabel1,mimalabel2,mimalabel3;
       private JButton okJButton,cancelJButton;
       private JLabel nameJLabel,passwordJLabel,note,label;
       private JPasswordField passwordJPasswordField;
       private JButton JButton,JButton1,JButton2,JButton3,JButton4,JButton5;
       private String name1;
       private String password1;
       private String user;
       private JTextArea onetext1,onetext2,twotext1,twotext2,threetext1,threetext2;
       private ImageIcon myImageIcon;
 
       public Login(){             
     
    	   createUserInterface(); // 调用创建用户界面方法 
       }
 
       private void createUserInterface(){  // 用户界面
    	   JFrame j1 = new JFrame("登陆界面");
    	   Container contentPane = j1.getContentPane();
    	   contentPane.setLayout( null );
    	  // getContentPane().setBackground(Color.CYAN); 
    	   
           userJPanel = new JPanel();  // 姓名  密码的边框            
           ImageIcon imgin = new ImageIcon("C:\\Users\\10449\\Desktop\\grey.png");
           Color c = new Color(24, 102, 134);

           userJPanel.setBackground(c);
           userJPanel.setBounds( 70, 240, 600, 192 );
           userJPanel.setBorder(BorderFactory.createEtchedBorder());       //显示一圈边儿（蚀刻边框）
           userJPanel.setLayout( null );
           
           
//    	   JLabel bg_in=new JLabel(imgin);
//    	   userJPanel.setOpaque(false);
//    	   userJPanel.setLayout(new FlowLayout());	
//    	   userJPanel.add(bg_in);
           
           contentPane.add( userJPanel );
                     
 
           //姓名框架
           nameJComboBox = new JComboBox();  // 下拉组件
           nameJComboBox.setBounds( 200, 24, 340, 50 );
           nameJComboBox.setBackground(c);
           nameJComboBox.addItem( "滑稽的男人" );
           nameJComboBox.addItem( "痛苦的男孩" );
           Font font_x = new Font("宋体",Font.BOLD,28);
           nameJComboBox.setFont(font_x ); // 修改字体样式
           nameJComboBox.setForeground(Color.white);
           nameJComboBox.setSelectedIndex( 0 ); 
           nameJComboBox.setEditable(true);
           userJPanel.add( nameJComboBox );
 
           pictureJLabel=new JLabel();  //狗头边框
           pictureJLabel.setBorder (BorderFactory.createEtchedBorder ());
           pictureJLabel.setBounds(260,0,225,225);  //（边框左边起始位置，，边框右边起始位置，）
           pictureJLabel.setIcon(new ImageIcon("图像.jpg"));//注意将图片文件放在项目的根目录
           contentPane.add(pictureJLabel);
 
           nameJLabel=new JLabel("姓  名：");  
           nameJLabel.setBounds(40,24,160,50);
           nameJLabel.setForeground(Color.white);  // 姓名的颜色
           Font font_xm = new Font("宋体",Font.BOLD,28);
           
           nameJLabel.setFont(font_xm ); // 修改字体样式
           userJPanel.add(nameJLabel);
           
           passwordJPasswordField=new JPasswordField();
           passwordJPasswordField.setBounds(200,120,340,50);
           userJPanel.add(passwordJPasswordField);
           
           //密码两个字体
           passwordJLabel=new JLabel("密  码：");
           passwordJLabel.setBounds(40,120,160,50);
           passwordJLabel.setForeground(Color.white);
           Font font_mm = new Font("宋体",Font.BOLD,28);
           passwordJLabel.setFont(font_mm ); // 修改字体样式
           userJPanel.add(passwordJLabel);
 
//           note=new JLabel("密码与用户名相同");  //最下边的笔记
//           note.setBounds(0,590,360,50);
           //note.set
//           add(note);
 
           okJButton=new JButton("登  陆");
           okJButton.setBounds(175,500,160,50);
           okJButton.setBackground(c);
           Font font_dl = new Font("宋体",Font.BOLD,28);
           okJButton.setForeground(Color.white);
		   okJButton.setFont(font_dl ); // 修改字体样式
           contentPane.add(okJButton);
           okJButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                       okJButtonActionPerformed(event);
                }
           });
         
           cancelJButton=new JButton("取  消");
           cancelJButton.setBounds(420,500,160,50);
           cancelJButton.setBackground(c);
           Font font_qx = new Font("宋体",Font.BOLD,28);
		   cancelJButton.setFont(font_qx ); // 修改字体样式
		   cancelJButton.setForeground(Color.white);
           contentPane.add(cancelJButton);
           cancelJButton.addActionListener(new ActionListener(){
        	   public void actionPerformed( ActionEvent event ){
        		   System.exit(0);        //退出登陆
               }
           });

           //-------------------------------背景图片添加
    	   j1.setBounds(500, 100, 760, 700);
    	   j1.setVisible(true);
    	   j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   ImageIcon img = new ImageIcon("C:\\Users\\10449\\Desktop\\截图1.png");
    	   
    	   JLabel bg=new JLabel(img);
    	   j1.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));
    	   bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    	   JPanel jp= (JPanel)j1.getContentPane();//强制类型转换
//    	   Container contain = contentPane.getContentPane();
//    	   ((JPanel) contain).setOpaque(false); //
    	   jp.setOpaque(false);
    	   jp.setLayout(new FlowLayout());
    	   //contain.setLayout(new FlowLayout());
    	  // contain.add(bg);	
    	   jp.add(bg);
           //----------------------------------------------------          
//           setTitle( "信息解密、解密助手" ); 
//           setSize( 760, 700 );  // 设置窗口生成的大小
//           setLocation(500,200);  //设置登录框的位置
//           setResizable( false );           //将最大化按钮设置为不可用
     }
 
    private void okJButtonActionPerformed( ActionEvent event ){
      //okJButton响应事件,检查用户名和密码的匹配
         name1= nameJComboBox.getSelectedItem().toString();
         if(name1.equals("滑稽的男人")){          
               if (passwordJPasswordField.getText().equals("1234567")){
                       showNewWindow();
                       setVisible( false);
                } else{
                       JOptionPane.showMessageDialog( this,"密码错误，助手无法提供服务","警告：密码错误 ！", JOptionPane.ERROR_MESSAGE );
                }
         }
         else if (name1.equals("痛苦的男孩")){
                if ( passwordJPasswordField.getText().equals("1234567")){
                    showNewWindow();
                    setVisible(false);
                }
                else{
                     JOptionPane.showMessageDialog( this,"密码错误，助手无法提供服务","警告：密码错误 ！", JOptionPane.ERROR_MESSAGE );
                }
         }
     }
    
       public void showNewWindow(){//此处生成新的窗口
    	      Color d = new Color(24, 102, 134);
              final JFrame jf=new JFrame("信息加密 / 解密");
    	      Container pane = jf.getContentPane();  // 需要设置容器才能显示出面板的颜色
              Font font_jf = new Font("宋体",Font.BOLD,20);
              jf.setFont(font_jf ); // 修改字体样式
              jf.setSize(900,600);
              jf.setLocation(200,100);//设置主框的位置              
              jf.setVisible(true);
              jf.setResizable(false);
              pane.setBackground(d);  // 以容器的身份获得了面板的颜色
              jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
              
              
              //特别注意，标签，按键要集中于一块，不要穿插
              JButton=new JButton("MD5加密");
              JButton.setBounds(40,90,130,50);
              Font font_jb = new Font("宋体",Font.BOLD,20);
              JButton.setBackground(d);
              JButton.setForeground(Color.white);
              JButton.setFont(font_jb ); // 修改字体样式
              jf.add(JButton);
              JButton.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent event){
                     //     JButtonActionPerformed(event);
                	   jiamiOne();
                   }
              });
              JButton1=new JButton("RSA加密");
              Font font_jb1 = new Font("宋体",Font.BOLD,20);
              JButton1.setBackground(d);
              JButton1.setForeground(Color.white);
              JButton1.setFont(font_jb1 ); // 修改字体样式
              JButton1.setBounds(40,190,130,50);
              jf.add(JButton1);
              JButton1.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent event){
                     //     JButtonActionPerformed(event);
                	   jiamiTwo();
                   }
              });
              JButton2=new JButton("DES加密");
              Font font_jb2 = new Font("宋体",Font.BOLD,20);
              JButton2.setBackground(d);
              JButton2.setForeground(Color.white);
              JButton2.setFont(font_jb2 ); // 修改字体样式
              JButton2.setBounds(40,290,130,50);
              jf.add(JButton2);
              JButton2.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent event){
                	   jiamiThree();
                   }
              });
              JButton3=new JButton("退出助手");
              JButton3.setBounds(40,390,130,50);
              Font font_jb3 = new Font("宋体",Font.BOLD,20);
              JButton3.setBackground(d);
              JButton3.setForeground(Color.white);
              JButton3.setFont(font_jb3 ); // 修改字体样式
              jf.add(JButton3);
              JButton3.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent event){
                	   System.exit(0);
                   }
              });
              JButton4=new JButton("使用帮助");
              JButton4.setBounds(350,400,130,50);
              Font font_jb4 = new Font("宋体",Font.BOLD,20);
              JButton4.setBackground(d);
              JButton4.setForeground(Color.white);
              JButton4.setFont(font_jb4 ); // 修改字体样式
              jf.add(JButton4);
              JButton4.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent event){
                			new HELP();
                   }
              });
              JButton5=new JButton("关于");
              JButton5.setBounds(600,400,130,50);
              Font font_jb5 = new Font("宋体",Font.BOLD,20);
              JButton5.setBackground(d);
              JButton5.setForeground(Color.white);
              JButton5.setFont(font_jb5 ); // 修改字体样式
              jf.add(JButton5);
              JButton5.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent event){
                     //     JButtonActionPerformed(event);
                	   jf.setEnabled(false);
                	   showNote();
                	   jf.setEnabled(true);
                   }
              });
              JLabel1=new JLabel();//设置中间的隔线
              JLabel1.setBackground(d);
              JLabel1.setBorder(BorderFactory.createEtchedBorder ());
              JLabel1.setBounds(200, 0, 2, 600);
              jf.add(JLabel1);
              nameJLabel=new JLabel();
              nameJLabel.setBackground(d);
              nameJLabel.setBounds(300,100,500,250);
              nameJLabel.setBorder(BorderFactory.createEtchedBorder());
              nameJLabel.setIcon(new ImageIcon("背景故事.png"));
              jf.add(nameJLabel);
              nameJLabel=new JLabel();//不知道为什么，必须重复一下才行
              nameJLabel.setBackground(d);
              nameJLabel.setBounds(300,100,500,250);
              nameJLabel.setBorder(BorderFactory.createEtchedBorder());
              jf.add(nameJLabel);
              
       }
       public void showNote(){
    	   JFrame note=new JFrame("关于");
    	   Container pane = note.getContentPane();
 	       Color d = new Color(24, 102, 134);
           note.setSize(500,200);
           note.setLocation(500,180);//设置主框的位置
           
           note.setVisible(true);
           note.setResizable(false);
           JLabel label=new JLabel("<html>"
        		+ "<font size = 5 color=\\\"white\\\">>"
//        		+ "<color=\"white\">"
        		+  "<br/>"
        		+  "<br/>"
        		+  "<br/>"
           		+ "&ensp;&ensp;&ensp;&ensp; &ensp; &ensp; &ensp; &ensp; &ensp; &ensp;技术不佳，多多包含！<br/>"        		
        		+  "<br/>"
        		+ "&ensp;&ensp;&ensp;&ensp; &ensp; &ensp; &ensp; &ensp; &ensp; &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;QQ: 759683753   <br/>"          		
           		+ "&ensp;&ensp;&ensp;&ensp; &ensp; &ensp; &ensp; &ensp; &ensp; &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;邮箱:Goodboy@outlook.com<br/>"
           		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
           	    + "</html>");
           //JLabel label=new JLabel("<html>第一行<br>第二行</html>");
           label.setBounds(300,100,500,450);
           pane.setBackground(d);
           label.setBorder(BorderFactory.createEtchedBorder());
           note.add(label);
       }
       public void showHelp(){ 
    	   JFrame help=new JFrame("使用帮助");
    	   help.setSize(500,400);
    	   help.setLocation(500,100);//设置主框的位置
    	   help.setVisible(true);
    	   help.setResizable(false);
    	  // JScrollPane jscrollpane = new JScrollPane(help);
    	   
    	   nameJLabel=new JLabel("第一个");
           nameJLabel.setBounds(300,100,500,250);
           nameJLabel.setBorder(BorderFactory.createEtchedBorder());
           help.add(nameJLabel);
           nameJLabel=new JLabel();//不知道为什么，必须重复一下才行
           nameJLabel.setBounds(300,100,500,250);
           nameJLabel.setBorder(BorderFactory.createEtchedBorder());
           help.add(nameJLabel);
       }
       public void jiamiOne(){
    	   new MD5();         
       }
       public void jiamiTwo(){
    	   new RSA();
       }
       public void jiamiThree(){
    	   new DES2();
       }
       public static void main( String[] args ){    
               JFrame.setDefaultLookAndFeelDecorated(true);//7CB4852BF8A8B7F5 装饰窗口
               Login mylogin = new Login( );  // 创建类Login
               mylogin.setVisible( true );  // 窗口初始化
               mylogin.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   // 窗口退出
       }
}
