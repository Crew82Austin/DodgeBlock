package org.crew82austin.dodgeblock;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Startup implements ActionListener{

	private boolean isHosting;
	private JFrame frame;
	
	public String name1;
	public String name2;
	public String IP;
	public String Port;
	private boolean start;
	
	JTextField tField1;
	
	public Startup(){
		frame = new JFrame("Setup");
		name1 = "";
		name2 = "";
		IP = "";
		Port = "";
		start = false;
	}
	
	public void displayStart(){
		System.out.println("Making Startup Window");
		
		Button button = new Button("Host");
		button.setActionCommand("getHostInfo");
		button.addActionListener(this);
		
	    tField1 = new JTextField(20);
		tField1.setActionCommand("typed");
		tField1.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.pack();
		
		frame.setSize(1920, 1080);
		frame.setVisible(true);
	}
	
	public void getHostInfo(){
		System.out.println("Getting host Info");
		frame.getContentPane().removeAll();;
		Button okButton = new Button("OK");
		okButton.setActionCommand("goToWaiting");
		okButton.addActionListener(this);
		
		frame.getContentPane().add(okButton);
		frame.pack();
	}
	
	public void actionPerformed(ActionEvent e){
		if("getHostInfo".equals(e.getActionCommand())){
			getHostInfo();
		}
		if("goToWaiting".equals(e.getActionCommand())){
			
		}
		
	}
	
}
