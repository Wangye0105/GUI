package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import gui.GUI_Signin;


import javax.swing.*;
class Login extends JFrame  {
	//String infile_pw,infile_name,infile_age,infile_number;
	JPanel p;
	JLabel lblname, lblpwd, lblid;
	JComboBox cmb;
	JTextField txt_name;
	JPasswordField txt_pw;
	JButton bt_comf,bt_cancel,bt_login;
	String id;
	Login(){
		super("Login windows");
		p=new JPanel();
		p.setLayout(null); // close layout to use bounds
		
		//set id choose
		lblid = new JLabel("ID:");
		cmb=new JComboBox();
		cmb.addItem("student");   
        cmb.addItem("teacher");
        cmb.addItem("admin");
        cmb.addItem("crouse");
        
        //set login system
		lblname = new JLabel("Accout:");
		lblpwd = new JLabel("PassWords:");
		txt_name = new JTextField("your number is Account");
		txt_pw = new JPasswordField(20);
		txt_pw.setEchoChar('*');
		bt_comf = new JButton("Submit");
		
		// set button
		bt_cancel = new JButton("Cancel");
		bt_login = new JButton("Login");
		
		
		// set position
		
		lblname.setBounds(30, 20, 80, 25);
		txt_name.setBounds(120, 20, 200, 25);
		lblpwd.setBounds(30, 50, 80, 25);
		txt_pw.setBounds(120, 50, 200, 25);
		
		lblid.setBounds(30, 90, 25, 25);
		cmb.setBounds(60, 90, 70, 25);
		bt_comf.setBounds(140, 90, 80, 25);
		bt_cancel.setBounds(230, 90, 80, 25);
		bt_login.setBounds(320, 90, 80, 25);
		
		//加入组件
		p.add(lblname);
		p.add(txt_name);
		p.add(lblpwd);
		p.add(txt_pw);
		p.add(lblid);
		p.add(cmb);
		p.add(bt_comf);
		p.add(bt_cancel);
		p.add(bt_login);
		this.add(p);    //添加panel
		this.setSize(410, 170);
		this.setLocation(300, 300);
		this.setResizable(false);  //设置窗口不可变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// add listener
		bt_comf.addActionListener(new ActionListener() {  //add inner class
			
			String infile_pw,infile_name,infile_age,infile_number;
			public void actionPerformed(ActionEvent e) {
				
				//get id
				String strcmb =new String((String)cmb.getSelectedItem());
				// get number
				int _number = Integer.parseInt(new String(txt_name.getText()));
				String path = "GUI\\"+strcmb+"\\"+_number; //输出文件相对路径 并用id区分；
				String filename ="\\info.txt";
				File file=new File(path+"\\"+filename);
				//输入流
				 try {
					  BufferedReader br=new BufferedReader(new FileReader(file)); //利用BR读取文件；
					    String temp=null;
					    StringBuffer sb=new StringBuffer();
					    temp=br.readLine();
					    while(temp!=null){
					        sb.append(temp+" ");
					        temp=br.readLine();
					    }
					    String infile_=sb.toString(); //得到文件中的信息 通过正则表达式获取密码
					    String pattern = "(.*)\\t密码password:(.*)\\t年龄age:(.*)\\t学号number:(\\d+)"; //()中为想获取的group
					    Pattern r = Pattern.compile(pattern);
					    Matcher m = r.matcher(infile_);
					    if (m.find( )) {
					         System.out.println("Found value: " + m.group(0) ); //0为全部
					         infile_name=m.group(1); //name
					         infile_pw= m.group(2); //pw
					         infile_age= m.group(3);  //age
					         infile_number=m.group(4); // number
					        
					         System.out.println(infile_number);
					         System.out.println(infile_pw+"\ninfile_pw length:"+infile_pw.length());
					      } else {
					         System.out.println("NO MATCH");
					      }
					    }
			
				 catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				// get account
				String strName = txt_name.getText();
				System.out.println("txt_name:"+strName);
				// get password
				String strPwd = new String(txt_pw.getPassword());
				System.out.println("txt_pw:"+strPwd+"\ntxt_pw length:"+strPwd.length());
				System.out.println("is the same?:"+strPwd.equals("infile_pw")); //由于源文件与面见编码不同会返回flase
				// Judge
				if (strPwd.equals("infile_pw"))
					JOptionPane.showMessageDialog(null, "Done！", "Attention", JOptionPane.INFORMATION_MESSAGE);
					// into the detail page
				if (strcmb.equals("student")) {
					new StudentPage(strcmb,infile_number,infile_name,infile_age);}
				if (strcmb.equals("teacher")) {
					new StudentPage(strcmb,infile_number,infile_name,infile_age);}
				if (strcmb.equals("admin")) {
					new StudentPage(strcmb,infile_number,infile_name,infile_age);}
				else
					JOptionPane.showMessageDialog(null, "Somthing wrong,PLz try again", "Attention", JOptionPane.INFORMATION_MESSAGE);
					return;
			}
		});
		// 
		bt_cancel.addActionListener(new ActionListener() {  // add inner class
			public void actionPerformed(ActionEvent e) {
				// 
				txt_name.setText(null);  //清空
				txt_pw.setText(null);    //清空
			}
		});
		bt_login.addActionListener(new ActionListener() { // add inner class
			public void actionPerformed(ActionEvent e) {
				GUI_Signin a =new GUI_Signin();
				a.Signin(); //当点击注册按钮时 开始执行 Signin程序
				
			}
		});
	}
}
public class GUI_login {
	
	public static void main(String args[]) {
		
		 new Login();}
	}
	
/*要让一个 Java 源文件打开时编码格式为 UTF-8，需要做2件事情：

1）设置Java 源文件的默认编码格式为UTF-8；

2）设置workspace的编码格式为UTF-8。 

相应设置如下：

        设置 Java 源文件的默认编码格式为 UTF-8 
                在 Windows->Preference 页面中，选择 General->Content Types 
                在右边的框中，选择 Text->Java Source File，将下面的 Default Encoding 改为 UTF-8 
        设置 workspace 的编码格式为 UTF-8 
                在 Windows->Preference 页面中，选择 General->WorkSpace 
                选择右侧框中的 Text File encoding，改为 UTF-8 
        设置完这2处，默认打开 Java 源文件就是UTF-8编码了。*/
