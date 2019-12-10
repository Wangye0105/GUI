package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import gui.GUI_login; //
class info{
	 String name;
	 static int number=1;
	 int age;
	 String pw;
	 info(String _name,int _age,String _pw){
		  name=_name;
		  number=this.number+1;
		  age= _age;
		  pw=_pw;
	}
	 String getname() {
		 return this.name;
	 }
	 int getnumber() {
		 return this.number;
	 }
	 int getage() {
		 return this.age;
	 }
	 String getpw() {
	 	return this.pw;
	 }
	 int setage(int _age) {
		 this.age =_age;
		 return this.age;
	 }
	//C:\Users\Wangye\eclipse-workspace\GUI\student
public void run( String id,int _number){
	
		
		 String path = "GUI\\"+id+"\\"+_number; //通过身份确定文件夹路径
		 String filename ="\\info.txt";
		 File file=new File(path+"\\"+filename);
		 mkDir(new File (path));
		 
         
     	 try {
			 
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
}	 
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

