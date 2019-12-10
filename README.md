# GUI
  ALL of them is  By Myself
在上传文件中 有一部分代码 有一部分是附带的用户信息 ，同样可以通过代码运行GUI增减修改信息，同时代码中有大量注释，以便阅读和理解代码。
# 存储方法
在数据存储方式中采用Buffer Writer 和Buffer Reader的方法 以每个用户一个文件加，基本信息一个txt，每个课程一个txt，在选课退课秩序删掉txt文件即可。同理教师，还有一个所有课程的文件夹，存储所有被创建的课程txt  <br> 
>-info（用户具体信息，如：学号，名字，年龄，密码，用户身份。).txt  
>-course1（课程具体信息，如：名称，地点 等）.txt       
>-course2.txt       
>>student1(文件夹)    
>>student2（文件夹）
>>>Students（文件夹）  
其中确保相对路径存在，用递归方法逐层建立  

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

