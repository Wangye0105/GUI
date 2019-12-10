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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.GUI_Signin;

public class Page extends JFrame{
	DefaultTableModel model1= null;  
	DefaultTableModel model2 = null;
	DefaultTableModel model3 = null;
	 //不同的内用 加载到不同的表中 在根据事件 在panel上 添加不同的 table
	JTable table1 = null; //表格组件 ！！！！！！！！  自学的 ！！！！
	JTable table2 = null; 
	JTable table3 = null; 
	JButton addBtn = null;
	JPanel p;
	JLabel lblnumb, lblname,lbl; //
	
	JButton bt_sled,bt_all,bt_sling,bt_drop; //
	Page(String id,String number,String name,String age){
		super(id+" Page");
		
		p=new JPanel();
		p.setLayout(null); // close 
		lbl =new JLabel();
		lblnumb = new JLabel("Number:       "+"     "+ number);
		lblname = new JLabel("Name\t:       "+"      "+name);
		bt_sled = new JButton("Selected");
		bt_all  = new JButton("ALL");
		bt_sling= new JButton("Available");
		bt_drop = new JButton("Drop");
	    String[][] datas = {};   //Date 等会用方法引入
	    String[] titles = { "课程编号", "课程名称","上课地点","授课老师","学分","上课时间" }; // title ！！
	    
	    
	    // table 1 is for  all
	    model1 = new DefaultTableModel(datas, titles);
	    table1 = new JTable(model1);
	    
	    // table 2 is for selected
	    model2 = new DefaultTableModel(datas, titles);
	    table2 = new JTable(model2);
	    
	    //table 3 is for available
	    model3 = new DefaultTableModel(datas, titles);
	    table3 = new JTable(model3);
	    
	    
	    
	    addBtn = new JButton("Add");
	    
	    
	    lblnumb.setBounds(10, 10, 300, 25);
	    lblname.setBounds(10, 50, 300, 25);
	    
	    bt_all.setBounds(10,130,100,25);
	   
	    bt_drop.setBounds(10,360,100,25);
	    addBtn.setBounds(10,400,100,25);
	    
	      p.add(lblnumb);
	      p.add(lblname);
	      p.add(addBtn);
	      p.add(bt_sled);
	      p.add(bt_all);
	      p.add(bt_sling);
	      p.add(bt_drop);
	      

	      this.add(p);    //添加panel
	      this.setSize(530, 470);
	      this.setLocation(300, 300);
	      this.setResizable(false);  //设置窗口不可变
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setVisible(true);
	      this.validate();
	    
}
}