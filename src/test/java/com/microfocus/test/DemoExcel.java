package com.microfocus.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//will be deleted
public class DemoExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("test-data/orange_data.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(file);
		
		XSSFSheet sheet= book.getSheet("invalidLoginTest");
		
		Object[][] data=new Object[2][3];
		
		for(int r=1;r<3;r++)
		{
			for(int c=0;c<3;c++)
			{
				String value= sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.println(value);
				data[r-1][c]=value;
			}
		}

		System.out.println();
	}

}
