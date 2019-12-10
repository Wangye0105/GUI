package gui;

import javax.swing.JOptionPane;

class student extends info{

	student(String _name, int _age, String _pw) {
		super(_name, _age, _pw); 
		super.run("student",this.getnumber());
		JOptionPane.showMessageDialog(null,"your number is:"+this.getnumber());
		System.out.println("Done");
	}
	 
}
