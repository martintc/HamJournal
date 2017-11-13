package com.hamjournal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ExistingUser extends User {
	
	String slash = "<//>";
	String all;
	// String PATH;
	String profilePATH = "/opt/HamJournal/UserSpace/Profiles/";

	public ExistingUser(String arg1) {
		super(arg1);
		// TODO Auto-generated constructor stub
	}
	
	void deserializeProfile () throws IOException, ClassNotFoundException {
		if (testExistence()) {
			FileInputStream openExistingProfile = new FileInputStream(profilePATH + callSign);
			System.out.println(openExistingProfile);
			ObjectInputStream openProfile = new ObjectInputStream(openExistingProfile);
			Object one = openProfile.readObject();
			Object two = openProfile.readObject();
			Object three = openProfile.readObject();
			String serializeCallSign = (String) one;
			String PATH = (String) two;
			String license = (String) three;
			openProfile.close();
			
			Profile.setCallSign(serializeCallSign);
			Profile.setPATH(PATH);
			Profile.setLicense(license);
			
		} else {
			// Do NOOTHING
		}
	}
	
	boolean testExistence() {
		File profile = new File(profilePATH + callSign);
		return profile.exists();
	}

}
