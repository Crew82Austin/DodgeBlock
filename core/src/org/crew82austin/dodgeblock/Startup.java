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
	private String userInput1;
	JTextField tField1;
	
	public Startup(){
		frame = new JFrame("Setup");
		userInput1 = "";
	}
	
	public void displayStart(){
		System.out.println("Making Startup Window");
		Button button = new Button();
		button.setLabel("PRESS MEEE!!!!!!!");
		button.setActionCommand("displayMessage");
		button.addActionListener(this);
		button.setSize(1920, 500);
		
	    tField1 = new JTextField(20);
		tField1.setActionCommand("typed");
		tField1.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		frame.getContentPane().add(tField1, BorderLayout.NORTH);
		frame.pack();
		
		frame.setSize(1920, 1080);
		frame.setVisible(true);
	}
	
	public void displayMessage(){
		System.out.println("Displaying Messsage");
		JLabel label = new JLabel("You Typed: "+tField1.getText(), JLabel.CENTER); 
		label.setFont(new Font("response", Font.PLAIN, 50));
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.pack();
		
		frame.setSize(1920, 1080);
	}
	
	public void actionPerformed(ActionEvent e){
		if("displayMessage".equals(e.getActionCommand())){
			displayMessage();
		}
		
	}
	
}
