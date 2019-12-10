package gui;

import javax.swing.JOptionPane;

public class teacher extends info{

	teacher(String _name,  int _age, String _pw) {
		super(_name, _age, _pw);
		run("teacher",this.getnumber());
		JOptionPane.showMessageDialog(null,"your number is:"+this.getnumber());
		System.out.println("Done");
	}
	 
}
