package com.hamjournal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class ProfileManager {

	/**
	 * @param args
	 */

	// static User user = new User();
	static boolean isNew;
	static String userName; // Call Sign
	static NewUser addUser;
	private ExistingUser existingUser;
	private JFrame logInFrame;
	private JPanel bottomPanel;
	private JLabel label;
	private JTextField userNameField;
	private JButton logInButton;
	private JButton createNewUserButton;
	private String name;
	// String profile;

	void gui() {
		logInFrame = new JFrame("Log In");
		logInButton = new JButton("Log In");
		userNameField = new JTextField();
		createNewUserButton = new JButton("Create New User");
		bottomPanel = new JPanel();
		label = new JLabel("Enter Callsign");

		logInFrame.getContentPane().add(BorderLayout.NORTH, label);
		logInFrame.getContentPane().add(BorderLayout.CENTER, userNameField);
		logInFrame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);

		bottomPanel.add(logInButton);
		bottomPanel.add(createNewUserButton);

		logInButton.addActionListener(new LogIn());
		createNewUserButton.addActionListener(new CreateUser());

		logInFrame.setSize(300, 150);
		logInFrame.setVisible(true);
		logInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public class LogIn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			name = userNameField.getText();
			existingUser = new ExistingUser(name);
			try {
				existingUser.deserializeProfile();
				logInFrame.dispose();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public class CreateUser implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			name = userNameField.getText();
			addUser = new NewUser(name);
			addUser.newUserInput();
			if (addUser.getSuccess()) {
				logInFrame.dispose();
			} else {
				// DO NOTHING
			}
		}
		
	}

}
