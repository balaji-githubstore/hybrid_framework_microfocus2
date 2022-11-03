package com.microfocus.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static Object[][] getJsonIntoTwoDimArray(String filePath, String testKey) throws IOException {
		FileInputStream file = new FileInputStream(filePath);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(file);

		Object[][] data = new Object[json.get(testKey).size()][json.get(testKey).get(0).size()];

		for (int r = 0; r < json.get(testKey).size(); r++) {
			for (int c = 0; c < json.get(testKey).get(0).size(); c++) {
				data[r][c] = json.get(testKey).get(r).get(c).asText();
			}
		}

		return data;
	}

}
