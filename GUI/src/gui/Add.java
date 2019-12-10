package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.cro_info;
//写个页面 输入流从croinfo类 调用
public class Add extends JFrame{  //重新起add页面   
	Add(String _t_name){					//构造函数
	super("Add windows");
	JPanel p;
	JLabel lbltime, lblt_name,lbladdress,lblname,lblcredit;
	JComboBox cmb,cmb2;
	JTextField name,address,t_name,credit;
	JButton bt_comf,bt_cancel;
	

	p=new JPanel();
	p.setLayout(null); // close layout to use bounds
	//set time choose
	lbltime = new JLabel("time:");
	cmb=new JComboBox(); //设置下拉菜单
	cmb.addItem("上午");   
    cmb.addItem("下午");
    cmb.addItem("下午");
    cmb.addItem("晚上");
    
    cmb2=new JComboBox(); //设置下拉菜单2
	cmb2.addItem("周一");   
    cmb2.addItem("周二");
    cmb2.addItem("周三");
    cmb2.addItem("周四");
    cmb2.addItem("周五");
    cmb2.addItem("周六");
    cmb2.addItem("周日");
    
    //set login system
    lblname = new JLabel("课程名称："); 
	lblt_name = new JLabel("授课老师："); 
	lbltime = new JLabel("time:");
	lbladdress = new JLabel("Address:");
	lblcredit = new JLabel("credit:");
	t_name = new JTextField(_t_name); //通过形参得到老师的名字 并再次直接打印
	address = new JTextField(20);
	
	credit = new JTextField(20);
	
	name = new JTextField(20);
	
	// set button
	bt_comf = new JButton("Submit");
	bt_cancel = new JButton("Cancel");
	
	// set position
	lblt_name.setBounds(10,20,80,25);
	t_name.setBounds(100,20,200,25);
	
	lblname.setBounds(10,50,80,25);
	name.setBounds(100,50,200,25);
	
	lbltime.setBounds(10,80,80,25);
	cmb.setBounds(100,80,100,25);
	cmb2.setBounds(220,80,100,25);
	
	lbladdress.setBounds(10,110,80,25);
	address.setBounds(100,110,200,25);
	
	lblcredit.setBounds(10,140,80,25);
	credit.setBounds(100,140,80,25);
	
	bt_comf.setBounds(100,375,80,25);
	bt_cancel.setBounds(200, 375, 80, 25);
	
	//add
	p.add(lbltime);
	p.add(cmb);
	p.add(cmb2);
	p.add(lblname);
	p.add(name);
	p.add(lblt_name);
	p.add(t_name);
	p.add(lbladdress);
	p.add(address);
	p.add(lblcredit);
	p.add(credit);
	
	p.add(bt_comf);
	p.add(bt_cancel);
	
	this.add(p);
	
	// set JFrame
	this.setSize(320,470);
	this.setLocation(470, 220);
	this.setResizable(false); //窗口不可变
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.validate();
	// set listener
	bt_comf.addActionListener(new ActionListener() {  //add inner class
		public void actionPerformed(ActionEvent e) {
			String _name, _credit, _address,_time,_t_name;
			String strcmb =new String((String)cmb.getSelectedItem()+(String)cmb2.getSelectedItem());
			_name=name.getText();
			_credit=credit.getText();
			_address=address.getText();
			_t_name=t_name.getText();
			_time=strcmb;
			System.out.println(_name+_credit+_address+_t_name+_time);
			new crouse(_name, _credit, _address,_time,_t_name);
		}
			});
	// 
	bt_cancel.addActionListener(new ActionListener() {  // add inner class
		public void actionPerformed(ActionEvent e) {
			// 
			name.setText(null);
			address.setText(null);
			credit.setText(null);
		}
	});
	}}
	
