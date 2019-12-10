package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//完整输入流,为ADD调用
class cro_info{
	 String t_name;
	 String name;
	 static int number=00001;
	 String credit;    //学分
	 String address;   //地址
	 String time;     //上课时间
	 cro_info(String _name,String _credit,String _address,String _time,String _t_name){
		  t_name=_t_name;
		  name=_name;
		  number=this.number+1;
		  credit= _credit;
		  address=_address;
		  time=_time;
	}
	 String getname() {
		 return this.name;
	 }
	 int getnumber() {
		 return this.number;
	 }
	 String getcredit() {
		 return this.credit;
	 }
	 String getaddress() {
	 	return this.address;
	 }
	 String gettime() {
		 return this.time;
	 }
	
	 public void run( String id,int _number){
			
			
		 String path = "GUI\\"+id+"\\cro"+_number; //通过身份确定文件夹路径
		 String filename ="\\info.txt";
		 File file=new File(path+"\\"+filename);
		 mkDir(new File (path));
		  
         
     	 try {
			 
			 BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			 String name = this.getname() ; 
			 String credit =this.getcredit();
			 String time= this.gettime();
			 String address = this.getaddress();
			 int number =this.getnumber();
			 bw.append("课程编号:"+number+"\t课程名称:"+name+"\t上课地点:"+address+"\t授课老师:"+t_name+"学分:"+credit+"上课时间:"+time); //为了方便之后的正则在每个信息前就按住标识
			 bw.newLine();
			 bw.flush();
			 bw.close();
		 } 
		 catch (IOException e) { //
			 
			e.printStackTrace();
		 }
     	 // add into all file
     	 String path_all = "GUI\\"+"crosuse"+"\\cor"+_number; //通过身份确定文件夹路径
		 String filename_all ="\\info.txt";
		 File file_all=new File(path_all+"\\"+filename_all);
		 mkDir(new File (path_all));
		 
         
     	 try {
			 
			 BufferedWriter bw = new BufferedWriter(new FileWriter(file_all,true));
			 String name = this.getname() ; 
			 String credit =this.getcredit();
			 String time= this.gettime();
			 String address = this.getaddress();
			 int number =this.getnumber();
			 bw.append("课程编号:"+number+"\t课程名称:"+name+"\t上课地点:"+address+"\t授课老师:"+t_name+"学分:"+credit+"上课时间:"+time); //为了方便之后的正则在每个信息前就按住标识
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

class crouse extends cro_info{  

	crouse(String _name,String _credit,String _address,String _time,String t_name) {
		super(_name, _credit, _address,_time,t_name);
		
		
		System.out.println("Done");
	}
	 
}	
