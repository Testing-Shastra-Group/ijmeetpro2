package com.sp.utilities;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Constants {

	public static WebDriver ldriver;
	
	

	public static String getProperties(String key) {
		String value=null;
		String projectPath = System.getProperty("user.dir")+"/src/test/java/com/sp/utilities/Objectproperty.properties";

		try {
			FileInputStream fis = new FileInputStream(projectPath); 
			Properties prop = new Properties();		
			prop.load(fis);
			value=prop.getProperty(key);
			
		} catch (Exception e) {
			System.out.println("File is not found");
		}
		
		return value;
	}
	
}