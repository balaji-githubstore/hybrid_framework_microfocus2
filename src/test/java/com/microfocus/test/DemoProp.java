package com.microfocus.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DemoProp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("test-data/data.properties"));
		
		String value=prop.getProperty("url");
		System.out.println(value);

	}

}
