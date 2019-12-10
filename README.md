# GUI
  ALL of them are By Myself  ！
在上传文件中 有一部分代码 有一部分是附带的用户信息 ，同样可以通过代码运行GUI增减修改信息，同时代码中有大量注释，以便阅读和理解代码。
# 存储方法
在数据存储方式中采用Buffer Writer 和Buffer Reader的方法 以每个用户一个文件加，基本信息一个txt，每个课程一个txt，在选课退课秩序删掉txt文件即可。同理教师，  
此外仍一个所有课程的文件夹，存储所有被创建的课程txt  <br> 
>-info（用户具体信息，如：学号，名字，年龄，密码，用户身份。).txt  
>-course1（课程具体信息，如：名称，地点 等）.txt       
>-course2.txt       
>>student1(文件夹)    
>>student2（文件夹）
>>>Students（文件夹）  

### 如下图片所示：   
#### 所有身份会存放到不同的身份文件夹中，以便之后选择，而身份的选择是通过下拉菜单选择的  
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E6%B3%A8%E5%86%8C%E8%BA%AB%E4%BB%BD%E9%80%89%E6%8B%A9.png">  

<img src="https://github.com/Wangye0105/imageJava/blob/master/flodsample.png"  width=700 > 
#### 每个用户以自身number命名，为了确保number不重复，用关键字static修饰  <br>
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E7%99%BB%E9%99%86%E7%95%8C%E9%9D%A2.png"  width=700 >  
   
#### 用户的所有的资料都会存放在自己的文件夹中，会有info（详细信息），还有已选课程  
<img src="https://github.com/Wangye0105/imageJava/blob/master/txtstore.png"  width=700 >  
#### 这里是用户详细信息的存储信息，之后会用io流取出，再用正则表达式获取相应信息    
<img src="https://github.com/Wangye0105/imageJava/blob/master/txtsample.png">  
其中确保相对路径存在，用递归方法逐层建立  
```jave
 String path_all = "GUI\\"+"crouse"+"\\cro"+_number; //通过身份确定文件夹路径
   		 	String filename_all =".txt";
```
```java
	   void mkDir(File file){  //递归创建路径
		   if(file.getParentFile().exists())
		   {
			   file.mkdir();
		   }
		   else{
			   mkDir(file.getParentFile());
			   file.mkdir();
			   }
		   }
}
```
# 代码展示  
## GUI  
### Jframe2newJframe  
#### 第一种是调用新类的方法
  
``` java  
bt_login.addActionListener(new ActionListener() { // add inner class
			public void actionPerformed(ActionEvent e) {
				GUI_Signin a =new GUI_Signin();
				a.Signin(); //当点击注册按钮时 开始执行 Signin程序
				
			}
```
#### 第二种是直接调用新类的构造函数（我比较喜欢用这个，比较简洁） 
这是我的主函数 并且第一个界面开始
```java
public class GUI_login {
	
	public static void main(String args[]) {
		
		 new Login();}
	}
```  
可以看到Login的构造数是这样的  
```jave
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
```
或者像这样事件界面跳转
```java
if (strcmb.equals("admin")) {
					new admin(strName,intage,strPwd);//这里因为就用一次 可以使用匿名函数 更简洁
				}
```
### javax.swing.JTable  
这个是我在书上和网上自学的，嘻嘻嘻  
#### 首先表单中有两个组件，一个是model，一个是放model的tabel，其中 tabel还可以放在JScrollPane中 这样就可滚动表单
```model1.addRow(new String[] {number,name,address,t_name,credit,time}); ```  
这句话是在model中添加信息，每一维数据之间用逗号"，"隔开
```model1.setRowCount(0);```  
当清空medel，自然而然便会清空表格，每次add新的课程进入，为了避免重复，便会先清空表单，再read文件，重新构建model。
### Listener 
我比较喜欢用内类直接写事件，这样代码简洁，逻辑清晰
```java
bt_all.addActionListener(new ActionListener() {
 
	         @Override
	         public void actionPerformed(ActionEvent e)
	         {}
		 
```
## IO流
### BufferWriter & BufferReader
BufferedReader br=new BufferedReader(new FileReader(file_all)); //利用BR读取文件；
在写文件的时候需要注意bw.flush();和bw.close();
```java
	 
			 BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			 String name = this.getname() ; 
			 String pw =this.getpw();
			 int age= this.getage();
			 int number =this.getnumber();
			 bw.append(name+"\t密码password:"+pw+"\t年龄age:"+age+"\t学号number:"+number); //为了方便之后的正则在每个信息前就按住标识
			 bw.newLine();
			 bw.flush();
			 bw.close();
		 } 
		 catch (IOException e) { //
			 
			e.printStackTrace();
		 }
```
### 同时每此在new文件或者打开文件时候 一定要记得加异常捕捉，这点在IO流中经常会用到（其实你不加，在eclipse中会报错变提供为你加异常处理的修改方案）
## Regular Expression   
这里用到的正则表达式是
```
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
```
## 这里提供了一个类的部分代码，可以完美的全部展示上述内容  
```java
public class StudentPage extends JFrame{
	DefaultTableModel model1= null;  
	DefaultTableModel model2 = null;
	DefaultTableModel model3 = null;
	 //不同的内容 加载到不同的表中 在根据事件 在panel上 添加不同的 table
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
		
```
#  界面展示  
###  登录界面  
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E7%99%BB%E9%99%86%E7%95%8C%E9%9D%A2.png">  
其中console中会打印出详细信息，并且提供与储存信息是否一致  
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E7%99%BB%E5%BD%95%E9%AA%8C%E8%AF%81%E5%AF%86%E7%A0%81.png">  
###  注册界面  
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E6%B3%A8%E5%86%8C%E8%BA%AB%E4%BB%BD%E9%80%89%E6%8B%A9.png">  
如果两次密码不一样会提示错误，并自动清除密码栏，要求重新填写  
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E6%B3%A8%E5%86%8C%E5%AF%86%E7%A0%81%E7%9B%B8%E5%90%8C.png">  
相应的简单清空代码和密码正确机制  

```
if(!strPwd.equals(strPwd2)) {  
	                JOptionPane.showMessageDialog(null,"Passwords are inconsistent twice");
	                pw.setText(null);  //清空
	                pw2.setText(null);
	                return; 
				}
				
```  

注册成果后 便会将信息自动以txt格式生成文件  
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E6%B3%A8%E5%86%8C%E6%88%90%E6%9E%9C%E5%90%8E%E8%87%AA%E5%8A%A8%E7%94%9F%E4%BA%A7%E6%96%87%E4%BB%B6.png" width=700>
###  详细界面  
在登陆成功后，会根据身份的不同进入不同身份的操作界面，这里用老师的来演示  
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E7%99%BB%E9%99%86%E6%88%90%E5%8A%9F%E5%90%8E%E7%9A%84%E6%95%99%E5%B8%88%E7%95%8C%E9%9D%A2.png"> 
老师会的add 是增加课程的按钮，这里与学生的add摁键不一样，用了不一样的事件  
all按键时查看所有信息按键，当老师添加完课程后，学生便可以查看到
<img src="https://github.com/Wangye0105/imageJava/blob/master/%E5%AD%A6%E7%94%9F%E5%92%8C%20%E6%95%99%E5%B8%88%E7%9A%84add%E7%95%8C%E9%9D%A2.png">  
<img src="https://github.com/Wangye0105/imageJava/blob/master/add%E4%B9%8B%E5%90%8E%E7%9A%84%E4%BF%A1%E6%81%AF%E5%AD%98%E5%82%A8.png">
而老师添加的课程会在course文件夹中存放，同时也会在老师自己的文件夹中存放，当老师不该授课老师的时候便默认为自己，如果更改授课老师，便会存放到该授课老师的文件中。  
而管理员界面便是通过这一方法为老师们添加课程信息。  

###  退选界面   
这里可以看到当学生退课或老师退课时，界面所发生的变化，以及自己的文件夹中的变化，这里用学生来举例：  
退课之后界面发生的变化：  
<img src="https://github.com/Wangye0105/imageJava/blob/master/drop%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%90%8E%E7%9A%84%E4%BF%A1%E6%81%AF.png">  

退课之后文件夹中的变化：  
<img src="https://github.com/Wangye0105/imageJava/blob/master/drop%E4%B9%8B%E5%90%8E%E7%9A%84.png">  
不难发现文件夹中cro1的文件被清除  

#  end~

