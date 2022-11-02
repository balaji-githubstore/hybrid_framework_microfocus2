package com.microfocus.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
//data provider
public class DataUtils {
	
	/*
	 * 1. commonDataProvider can be used by all @Test method
	 * 2. Make sure the @Test method name is the sheetname
	 */
	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException
	{
		//current @Test method name is the sheetname
		String testMethodName=method.getName();	
		Object[][] data= ExcelUtils.getSheetIntoTwoDimArray("test-data/orange_data.xlsx", testMethodName);
		return data;
	}
	
	
	@DataProvider
	public Object[][] invalidLoginData()
	{
		Object[][] data=new Object[2][3];
		//i - number of test cases
		//j - number of arguments/parameters
		data[0][0]="Saul";
		data[0][1]="Saul123";
		data[0][2]="Invalid credentials";
		
		data[1][0]="Peter";
		data[1][1]="Peter123";
		data[1][2]="Invalid credentials";
		
		return data;
	}

}
