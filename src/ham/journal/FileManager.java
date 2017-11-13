package com.hamjournal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
 * FileManager class will take care of all saving and reading of files
 * Searching for files will, as of now, be handled within the SearchFile class
 */

public class FileManager {
	
	// create instances
	protected FileWriter fileSaver;
	protected String headerInformation;
	private String slash = "<//>";
	private String x[];
	private String fileName;
	protected String journalInput;
	protected String stringData;
	public File file;
	private String PATH = Profile.getPATH();
	
	// Save information put into the entry GUI
	boolean saveEntry(String input1, String input2) throws IOException{
		try {
			// Code to take Date and make it a file name
			headerInformation = input1;
			x = input1.split(slash);
			fileName = x[0];
			// fileName will be what the user put into the "date" JTextField
			journalInput = input2;
			fileSaver = new FileWriter(PATH + fileName);
			// Writting data into the file to be stored
			fileSaver.write(headerInformation + slash + journalInput);
			fileSaver.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Code below reads the contents of the file put in to the search bar in SearFile class
	 String readTheFile(String s) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(s));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    stringData = sb.toString();
		    return stringData;
		} finally {
		    br.close();
		}
	}
}