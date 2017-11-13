package com.hamjournal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class EntryGui {

	/*
	 * Generic GUI class to be used in creation of both new and opening old
	 * enteries.
	 * 
	 */
	
	// create objects
	FileManager fileAction = new FileManager();
	
	// Instances
	private JFrame frame;
	private JButton saveButton;
	protected JButton closeButton;
	protected JTextField date;
	protected JTextField callSign;
	protected JTextField modes;
	protected JTextField bands;
	protected JTextArea journal;
	private String slash = "<//>";
	
	
	
	void go(){
		// DO NOTHING
	}
	
	// Create new Entry GUI
	void gui() {
		frame = new JFrame("New Entry");
		JPanel mainUpperPanel = new JPanel();
		JPanel mainLowerPanel = new JPanel();
		mainUpperPanel.setLayout(new BoxLayout(mainUpperPanel, BoxLayout.Y_AXIS));
		// mainUpperPanel.setLayout(new FlowLayout());
		mainLowerPanel.setLayout(new BoxLayout(mainLowerPanel, BoxLayout.Y_AXIS));
		// mainLowerPanel.setLayout(new FlowLayout());
		
		JPanel bottomPanel = new JPanel();
		
		saveButton = new JButton("Save");
		closeButton = new JButton("Close");
		
		JLabel dateLabel = new JLabel("Date: ");
		JLabel callSignLabel = new JLabel("Call Sign: ");
		JLabel modeLabel = new JLabel("Modes: ");
		JLabel bandLabel = new JLabel("Bands used: ");
		JLabel journalLabel = new JLabel("Add more Detail to Today's Events: ");
		
		date = new JTextField();
		callSign = new JTextField(Profile.getCallSign());
		modes = new JTextField();
		bands = new JTextField();
		
		journal = new JTextArea();
		
		mainUpperPanel.add(dateLabel);
		mainUpperPanel.add(date);
		mainUpperPanel.add(callSignLabel);
		mainUpperPanel.add(callSign);
		mainUpperPanel.add(bandLabel);
		mainUpperPanel.add(bands);
		mainUpperPanel.add(modeLabel);
		mainUpperPanel.add(modes);
		mainUpperPanel.add(journalLabel);
		mainLowerPanel.add(journal);
		bottomPanel.add(saveButton);
		bottomPanel.add(closeButton);
		frame.getContentPane().add(BorderLayout.NORTH, mainUpperPanel);
		frame.getContentPane().add(BorderLayout.CENTER, mainLowerPanel);
		// frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
		
		// listener for JButtons
		saveButton.addActionListener(new SaveEntry());
		closeButton.addActionListener(new CloseTheWindow());
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		
	}
	
	// method Override for opening existing Entry
	void gui(String s) {
		
		String[] content = s.split(slash);
		
		frame = new JFrame("New Entry");
		JPanel mainUpperPanel = new JPanel();
		JPanel mainLowerPanel = new JPanel();
		mainUpperPanel.setLayout(new BoxLayout(mainUpperPanel, BoxLayout.Y_AXIS));
		// mainUpperPanel.setLayout(new FlowLayout());
		mainLowerPanel.setLayout(new BoxLayout(mainLowerPanel, BoxLayout.Y_AXIS));
		// mainLowerPanel.setLayout(new FlowLayout());
		
		JPanel bottomPanel = new JPanel();
		
		saveButton = new JButton("Save");
		closeButton = new JButton("Close");
		
		JLabel dateLabel = new JLabel("Date: ");
		JLabel callSignLabel = new JLabel("Call Sign: ");
		JLabel modeLabel = new JLabel("Modes: ");
		JLabel bandLabel = new JLabel("Bands used: ");
		JLabel journalLabel = new JLabel("Add more Detail to Today's Events: ");
		
		date = new JTextField(content[0]);
		callSign = new JTextField(content[1]);
		modes = new JTextField(content[2]);
		bands = new JTextField(content[3]);
		journal = new JTextArea(content[4]);
		
		mainUpperPanel.add(dateLabel);
		mainUpperPanel.add(date);
		mainUpperPanel.add(callSignLabel);
		mainUpperPanel.add(callSign);
		mainUpperPanel.add(bandLabel);
		mainUpperPanel.add(bands);
		mainUpperPanel.add(modeLabel);
		mainUpperPanel.add(modes);
		mainUpperPanel.add(journalLabel);
		mainLowerPanel.add(journal);
		bottomPanel.add(saveButton);
		bottomPanel.add(closeButton);
		frame.getContentPane().add(BorderLayout.NORTH, mainUpperPanel);
		frame.getContentPane().add(BorderLayout.CENTER, mainLowerPanel);
		// frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
		
		// listener for JButtons
		saveButton.addActionListener(new SaveEntry());
		closeButton.addActionListener(new CloseTheWindow());
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		
	}
	
	// Button action event for the "Close" Button
	public class CloseTheWindow implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	}
	
	// 
	class SaveEntry implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			fileAction = new FileManager();
			String slash = "<//>";
			String baseText = date.getText() + slash + callSign.getText() + slash + bands.getText() + slash + modes.getText();
			String journalText = journal.getText();
			// fileAction.setFileContents(baseText, journalText);
			try {
				if (fileAction.saveEntry(baseText, journalText)) {
					frame.dispose();
				} else {
					saveButton.setText("Could not save file!");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}