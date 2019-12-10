package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import gui.info;

public class StudentPage extends JFrame{
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
	StudentPage(String id, String number, String name, String age) { 
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
	    
	    bt_sled.setBounds(10,90,100,25);
		bt_sling.setBounds(10,170,100,25);//这两个按钮 只有学生  故放在该类中  同时admin 和 teacher 的page里面就没有这令个按钮
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

		bt_all.addActionListener(new ActionListener() {
 
	         @Override
	         public void actionPerformed(ActionEvent e)
	         {	//清空表单 重现加载
	        	 model1.setRowCount(0);
	        System.out.println(cro_info.number);
        	 for(int _number=1; _number<=3; _number++) { 
        		 
        	 String t_name = null;
	    	 String name=null;
	    	 String number = null;
	    	 String credit = null;    //学分
	    	 String address = null;   //地址
	    	 String time = null;     //上课时间
        	 lbl.setText("List of all crouse");
        	 lbl.setBounds(130,70,380,25);
         	JScrollPane s1 =new JScrollPane(table1);
            //model1.addRow(new String[] {null }); //需要添加函数
            s1.setBounds(130,90,380,335);
            p.add(s1);
            String path_all = "GUI\\"+"crouse"+"\\cro"+_number; //通过身份确定文件夹路径
   		 	String filename_all =".txt";
   		 	File file_all=new File(""+path_all+filename_all);
   		 	System.out.println(file_all);
			//输入流
			 try {
				  BufferedReader br=new BufferedReader(new FileReader(file_all)); //利用BR读取文件；
				    String temp=null;
				    StringBuffer sb=new StringBuffer();
				    temp=br.readLine();
				    while(temp!=null){
				        sb.append(temp+" ");
				        temp=br.readLine();
				        
				    }
				    
				    String infile_=sb.toString(); //得到文件中的信息 通过正则表达式获取密码
				    System.out.println(infile_);
				    String pattern = "number:(.*)\\tname:(.*)\\taddress:(.*)\\tt_name:(.*)\\tcredit:(.*)\\ttimes:(.*)"; 
				    //()中为想获取的group
				    Pattern r = Pattern.compile(pattern);
				    Matcher m = r.matcher(infile_);
				    if (m.find( )) {
				         System.out.println("Found value: " + m.group(0) ); //0为全部
				         number=m.group(1); //number
				         name=m.group(2);//name
				         address=m.group(3);//address
				         t_name=m.group(4);//t_name
				         credit=m.group(5);//credit
				         time=m.group(6);//time
				         model1.addRow(new String[] {number,name,address,t_name,credit,time}); //由政策表达式写出；
				         
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
			
         }
      }});
		
		
		
		
		
		
		
		
		
		bt_sled.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e)
	         {	 //清空表单 重现加载
	        	 model2.setRowCount(0);
        	 for(int _number=1; _number<=cro_info.number; _number++) { 
        	 //通过调用 croinfo类的number参数  可知道 总共有多少个课程被创建 从而就可以知道 循环最大次数
        	String t_name = null;
    	 	String name=null;
    	 	String number = null;
    	 	String credit = null;    //学分
    	 	String address = null;   //地址
    	 	String time = null;     //上课时间
        	lbl.setText("List of Selected crouse");
        	lbl.setBounds(130,70,380,25);
         	JScrollPane s2 =new JScrollPane(table2);
         	s2.setBounds(130,90,380,335);
         	p.add(s2);
         	
         	String path = "GUI\\"+id+"\\"+"cro"+_number; //通过身份确定文件夹路径
         	String filename =".txt";
         	File file=new File(path+filename);
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
				    String pattern = "课程编号:(.*)\t课程名称:(.*)\t上课地点:(.*)\t授课老师(.*)学分:(.*)上课时间:(.*)"; 
				    //()中为想获取的group
				    Pattern r = Pattern.compile(pattern);
				    Matcher m = r.matcher(infile_);
				    if (m.find( )) {
				         System.out.println("Found value: " + m.group(0) ); //0为全部
				         number=m.group(1); //number
				         name=m.group(2);//name
				         address=m.group(3);//address
				         t_name=m.group(4);//t_name
				         credit=m.group(5);//credit
				         time=m.group(6);//time
				         model2.addRow(new String[] {number,name,address,t_name,credit,time}); //由政策表达式写出
				         
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
			
         }}});
	

		
		
		bt_sling.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e)
	         {	 model2.setRowCount(0);
        	 for(int _number=1; _number<=cro_info.number; _number++) { 
        	 //通过调用 croinfo类的number参数  可知道 总共有多少个课程被创建 从而就可以知道 循环最大次数
        	String t_name = null;
    	 	String name=null;
    	 	String number = null;
    	 	String credit = null;    //学分
    	 	String address = null;   //地址
    	 	String time = null;     //上课时间
        	lbl.setText("List of Selected crouse");
         	JScrollPane s2 =new JScrollPane(table2);
         	s2.setBounds(130,90,380,335);
         	p.add(s2);
         	
         	String path = "GUI\\"+id+"\\"+"cro"+_number; //通过身份确定文件夹路径
         	String filename =".txt";
         	File file=new File(path+filename);
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
				    String pattern = "课程编号:(.*)\t课程名称:(.*)\t上课地点:(.*)\t授课老师(.*)学分:(.*)上课时间:(.*)"; 
				    //()中为想获取的group
				    Pattern r = Pattern.compile(pattern);
				    Matcher m = r.matcher(infile_);
				    if (m.find( )) {
				         System.out.println("Found value: " + m.group(0) ); //0为全部
				         number=m.group(1); //number
				         name=m.group(2);//name
				         address=m.group(3);//address
				         t_name=m.group(4);//t_name
				         credit=m.group(5);//credit
				         time=m.group(6);//time
				         model2.addRow(new String[] {number,name,address,t_name,credit,time}); //由政策表达式写出
				         
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
			
         }}});
	
		
		
		addBtn.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e)
	         {	lbl.setText("adding...");   //according  the list of type change label
	         	System.out.println("Add(name):"+name);
	         	new Add(name);
	         }
	      });
		
		
		bt_drop.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e)
	         {	lbl.setText("droping...");
	            model2.addRow(new String[] {null }); //需要添加函数
	         }
	      });
		
	}

	

	
	
}
