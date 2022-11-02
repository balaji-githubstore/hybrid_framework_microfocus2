package com.microfocus.utilities;

import org.testng.annotations.DataProvider;
//data provider
public class DataUtils {
	
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
