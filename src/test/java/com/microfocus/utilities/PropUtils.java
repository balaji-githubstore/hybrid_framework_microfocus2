package com.microfocus.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropUtils {

	public static String getValue(String filePath,String key) throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream(filePath));	
		return prop.getProperty(key);
	}
}
