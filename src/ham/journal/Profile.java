package com.hamjournal;

public class Profile {
	
	private static Profile profile = new Profile();
	
	private static String callSign;
	private static String PATH;
	private static String license;
	
	private Profile() {
		// DO NOTHING
	}
	
	public static Profile getInstance() {
		return profile;
	}
	
	public static void setCallSign(String x) {
		callSign = x;
	}
	
	public static String getCallSign() {
		return callSign;
	}
	
	public static void setPATH(String x) {
		PATH = x;
	}
	public static String getPATH() {
		return PATH;
	}
	
	public static void setLicense(String x) {
		license = x;
	}
	
	public static String getLicense() {
		return license;
	}
	
}
