package com.hamjournal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.*;

public class NewUser extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2057138064697176963L;
	/**
	 * 
	 */
	
	JFrame createUserFrame;
	JButton makeUser;
	JTextField textFieldPATH, textFieldLicense, textFieldCallSign;
	JPanel centerPanel /* , northCenterPanel, centerCenterPanel, southCenterPanel */;
	String profilePATH = "/opt/HamJournal/UserSpace/Profiles/";
	
	public boolean success;
	
	// private static final long serialVersionUID = 1L;

	public NewUser(String arg1) {
		super(arg1);
		// TODO Auto-generated constructor stub
	}
	
	void newUserInput() {
		createUserFrame = new JFrame("Make new User");
		JLabel labelPATH = new JLabel("Set path");
		JLabel labelLicense = new JLabel("License Level");
		JLabel labelCallSign = new JLabel("Call Sign");
		textFieldPATH = new JTextField();
		textFieldLicense = new JTextField();
		textFieldCallSign = new JTextField(callSign);
		makeUser = new JButton("Create New User");
		centerPanel = new JPanel();

		createUserFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		centerPanel.add(labelCallSign);
		centerPanel.add(textFieldCallSign);

		centerPanel.add(labelPATH);
		centerPanel.add(textFieldPATH);
	
		centerPanel.add(labelLicense);
		centerPanel.add(textFieldLicense);
		
		createUserFrame.getContentPane().add(BorderLayout.SOUTH, makeUser);
		
		makeUser.addActionListener(new onClickSerialize());
		
		createUserFrame.setSize(500, 500);
		createUserFrame.setVisible(true);
		createUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	boolean getSuccess() {
		return success;
	}
	
	class onClickSerialize implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String callSign = textFieldCallSign.getText();
			String PATH = textFieldPATH.getText();
			String license = textFieldLicense.getText();
			try {
				serializeProfile(callSign, PATH, license);
				success = true;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				success = false;
			}
			if (success) {
				createUserFrame.dispose();
			} else {
				// DO NOTHING
			}
		}
	
		void serializeProfile (String callSign, String PATH, String license) throws IOException {
			FileOutputStream newProfileFileStream = new FileOutputStream(profilePATH + callSign);
			ObjectOutputStream newProfile = new ObjectOutputStream(newProfileFileStream);
			newProfile.writeObject(callSign);
			newProfile.writeObject(PATH);
			newProfile.writeObject(license);
			newProfile.close();
		}
		
	}
	
}
