package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.info;

public class GUI_Signin {
	public void Signin() {
		JPanel p;
		JLabel lblid, lblname, lblpwd, lblpwd2,lblage;
		JComboBox cmb;
		JTextField name,age;
		JPasswordField pw, pw2;
		JButton bt_comf,bt_cancel;
		JFrame f=new JFrame("Singin windows");
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
		lblname = new JLabel("Name:");
		lblpwd = new JLabel("PassWords:");
		lblpwd2 = new JLabel("Confirm password :");
		lblage = new JLabel("age:");
		name = new JTextField(20);
		pw = new JPasswordField(20);
		pw.setEchoChar('*');
		pw2 = new JPasswordField(20);
		pw2.setEchoChar('*');
		age = new JTextField(20);
		
		// set button
		bt_comf = new JButton("Submit");
		bt_cancel = new JButton("Cancel");
		
		// set position
		lblid.setBounds(10, 25, 80, 25);
		cmb.setBounds(100, 25, 70, 25);
		
		lblname.setBounds(10,95,80,25);
		name.setBounds(100,95,200, 25);
		
		lblpwd.setBounds(10,165,80,25);
		pw.setBounds(100,165,200,25);
		
		lblpwd2.setBounds(10,235,80,25);
		pw2.setBounds(100,235,200,25);
		
		lblage.setBounds(10,305,80,25);
		age.setBounds(100,305,200,25);
		
		bt_comf.setBounds(100,375,80,25);
		bt_cancel.setBounds(200, 375, 80, 25);
		
		//add
		p.add(lblid);
		p.add(cmb);
		p.add(lblname);
		p.add(name);
		p.add(lblpwd);
		p.add(pw);
		p.add(lblpwd2);
		p.add(pw2);
		p.add(lblage);
		p.add(age);
		p.add(bt_comf);
		p.add(bt_cancel);
		
		f.add(p);
		
		// set JFrame
		f.setSize(320,470);
		f.setLocation(470, 220);
		f.setResizable(false); //窗口不可变
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		 
		// set listener
		bt_comf.addActionListener(new ActionListener() {  //add inner class
			public void actionPerformed(ActionEvent e) {
				// get account
				String strName = name.getText();
				// get password
				String strPwd = new String(pw.getPassword());
				String strPwd2 = new String(pw2.getPassword());
				//get id
				String strcmb =new String((String)cmb.getSelectedItem());
				//get  integer age
				int intage = Integer.parseInt(new String(age.getText()));
				// Judge
				if(!strPwd.equals(strPwd2)) {  
	                JOptionPane.showMessageDialog(null,"Passwords are inconsistent twice");
	                pw.setText(null);  //清空
	                pw2.setText(null);
	                return; 
				}
				
				
				if (strcmb.equals("student")) {
					
					new student(strName,intage,strPwd);
				}
				
				if (strcmb.equals("teacher")) {
					new teacher(strName,intage,strPwd);
				}
				
				if (strcmb.equals("admin")) {
					new admin(strName,intage,strPwd);
				}
				
				
				;
				
			}       
	            });
		// 
		bt_cancel.addActionListener(new ActionListener() {  // add inner class
			public void actionPerformed(ActionEvent e) {
				// 
				pw2.setText(null);
				pw.setText(null);
			}
		});
	}
}
