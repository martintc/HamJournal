package com.hamjournal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class SearchFile {
	
	private String parameter;
	public JTextField dateToSearchFor;
	protected JButton search;
	protected JButton closeWindow;
	protected JFrame popUpSearch;
	EntryGui openEntry;
	FileManager openFile;
	private String date;
	// private String PATH = "/home/todd/Desktop/Projects/HamJournal-2.0/";
	protected String PATH = Profile.getPATH();
	private String dataRead;
	boolean searchFile;
	private JPanel southPanel;
	
	// void go() {
		// popUpInput();
	// }
	
	void popUpInput() {
		popUpSearch = new JFrame("Search for Entry");
		dateToSearchFor = new JTextField();
		search = new JButton("Search");
		southPanel = new JPanel();
		JLabel label = new JLabel("Entry date to search for");
		closeWindow = new JButton("Close");
		
		search.addActionListener(new GetSearchParameter());
		closeWindow.addActionListener(new CloseTheWindow());
		
		popUpSearch.getContentPane().add(BorderLayout.NORTH, label);
		popUpSearch.getContentPane().add(BorderLayout.CENTER, dateToSearchFor);
		popUpSearch.getContentPane().add(BorderLayout.SOUTH, southPanel);
		
		southPanel.add(search);
		southPanel.add(closeWindow);
		
		popUpSearch.setSize(300, 110);
		popUpSearch.setVisible(true);
		popUpSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	String getDataRead() {
		return dataRead;
	}
	
	public class CloseTheWindow implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			popUpSearch.dispose();
		}
	}
	
	public class GetSearchParameter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			date = dateToSearchFor.getText();
			parameter = PATH + date;
			// System.out.println(parameter);
			openFile = new FileManager();
			openEntry = new EntryGui();
				try {
					if (searchFile(parameter)) {
						dataRead = openFile.readTheFile(parameter);
						System.out.println(dataRead);
						// popUpSearch.dispose();
						openEntry.gui(dataRead);
						
					} else {
						search.setText("Could not find file!");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		boolean searchFile(String s) throws IOException {
			File file = new File(s);
			if (file.exists()) {
				return true;
			} else {
				return false;
			}
		}
	}	
}