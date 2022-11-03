package com.microfocus.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJson {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		FileInputStream file = new FileInputStream("test-data/orange_data.json");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(file);

		System.out.println(json.get("invalidLoginTest"));
		System.out.println(json.get("invalidLoginTest").get(0));
		System.out.println(json.get("invalidLoginTest").get(1));

		System.out.println(json.get("invalidLoginTest").size());
		System.out.println(json.get("invalidLoginTest").get(0).size());

		Object[][] data = new Object[json.get("invalidLoginTest").size()][json.get("invalidLoginTest").get(0).size()];

	
		for (int r = 0; r < json.get("invalidLoginTest").size(); r++) {
			for (int c = 0; c < json.get("invalidLoginTest").get(0).size(); c++) {
				data[r][c] = json.get("invalidLoginTest").get(r).get(c);
				System.out.println(json.get("invalidLoginTest").get(r).get(c).asText());
			}
		}
		
		System.out.println(data);
	}
	

}
