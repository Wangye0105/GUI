package gui;

import javax.swing.JOptionPane;

class admin extends info{

	admin(String _name,  int _age, String _pw) {
		super(_name,  _age, _pw);
		run("admin",this.getnumber());
		JOptionPane.showMessageDialog(null,"your number is:"+this.getnumber());
		System.out.println("Done");
	}
	 
} 
