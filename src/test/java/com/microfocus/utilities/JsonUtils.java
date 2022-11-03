package com.microfocus.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static Object[][] getJsonIntoTwoDimArray() throws IOException
	{
		//will do it tomorrow
		FileInputStream file=new FileInputStream("test-data/data2.json");
        ObjectMapper mapper=new ObjectMapper();
        JsonNode json1= mapper.readTree(file);
        System.out.println(json1.get("invalidLoginTest").size());
        
        Object[][] data=new Object
        		[json1.get("invalidLoginTest").size()]
        		[json1.get("invalidLoginTest").get(0).size()];
        
        for(int i=0;i<json1.get("invalidLoginTest").size();i++)
        {
        	for(int j=0;j<json1.get("invalidLoginTest").get(0).size();j++)
        	{
        		System.out.println(json1.get("invalidLoginTest").get(i).get(j));
        		data[i][j]=json1.get("invalidLoginTest").get(i).get(j);
        	}
        }
		return data;
	}
	
//	@Test
//	public void getJsonIntoTwoDimArray2() throws IOException
//	{
//        FileInputStream file=new FileInputStream("test-data/data2.json");
//        ObjectMapper mapper=new ObjectMapper();
//        JsonNode json1= mapper.readTree(file);
//        System.out.println(json1.get("invalidLoginTest").size());
//        
//        Object[][] data=new Object
//        		[json1.get("invalidLoginTest").size()]
//        		[json1.get("invalidLoginTest").get(0).size()];
//        
//        for(int i=0;i<json1.get("invalidLoginTest").size();i++)
//        {
//        	for(int j=0;j<json1.get("invalidLoginTest").get(0).size();j++)
//        	{
//        		System.out.println(json1.get("invalidLoginTest").get(i).get(j));
//        		data[i][j]=json1.get("invalidLoginTest").get(i).get(j);
//        	}
//        }
//    
//        System.out.println(data);
//	}
}
