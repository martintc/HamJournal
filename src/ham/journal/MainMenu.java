package com.hamjournal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu {

	/**
	 * @param args
	 * Version 2.0 of "development phase"
	 * not for official release yet
	 */
	
	// Objects
	EntryGui entryGui = new EntryGui();
	
	 // start Instance declarations
	static MainMenu mainMenu = new MainMenu();
	private JFrame mainMenuFrame;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JLabel header;
	protected JButton createNewEntry;
	protected JButton openExistingEntry;
	protected JButton profileButton;
	protected JButton closeButton;
	
	
	public static void main(String[] args) {
		
		mainMenu.menu();
		
	}
	
	
	// GUI interface for the main Menu
	void menu() {
		// define instances
		mainMenuFrame = new JFrame("Ham Journal");
		centerPanel = new JPanel();
		northPanel = new JPanel();
		header = new JLabel("Ham Journal");
		createNewEntry = new JButton("New Entry");
		openExistingEntry = new JButton("Open Entry");
		profileButton = new JButton("Manage Profile");
		closeButton = new JButton("Close");
		
		// putting GUI together
		mainMenuFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		centerPanel.add(createNewEntry);
		centerPanel.add(openExistingEntry);
		centerPanel.add(profileButton);
		mainMenuFrame.getContentPane().add(BorderLayout.NORTH, northPanel);
		northPanel.add(header);
		mainMenuFrame.getContentPane().add(BorderLayout.SOUTH, closeButton);
		
		//action Listeners for Buttons
		createNewEntry.addActionListener(new GoCreateNew());
		openExistingEntry.addActionListener(new GoOpenExisting());
		profileButton.addActionListener(new onClickOpenProfileManager());
		closeButton.addActionListener(new onClickClose());
		
		// set mainMenuFrame
		mainMenuFrame.setSize(300, 300);
		mainMenuFrame.setVisible(true);
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	// Action for createNewEntry Button
	class GoCreateNew implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			entryGui.gui();
		}
	}
	// Action for openExistingEntry Button
	class GoOpenExisting implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			SearchFile search = new SearchFile();
			search.popUpInput();			
		}
	}
	
	class onClickOpenProfileManager implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			ProfileManager manageProfile = new ProfileManager();
			manageProfile.gui();
		}
	}
	
	class onClickClose implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			mainMenuFrame.dispose();
			System.exit(0);
		}
	}
}