package com.microfocus.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoTwoDimArray(String filePath, String sheetname) throws IOException {

		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][cellCount];

		DataFormatter format = new DataFormatter();
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				String value = format.formatCellValue(sheet.getRow(r).getCell(c));
				data[r - 1][c] = value;
			}
		}
		book.close();
		file.close();

		return data;
	}

	public static Object[][] getSheetIntoTwoDimArraySpecifyType(String filePath, String sheetname) throws IOException {

		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][cellCount];

		DataFormatter format = new DataFormatter();
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {

				if (sheet.getRow(r).getCell(c).getCellType() == CellType.NUMERIC) {
					double a = sheet.getRow(r).getCell(c).getNumericCellValue();

					if (a == (int) a) {
						data[r - 1][c] = Integer.parseInt(String.valueOf(a));
					} else {
						data[r - 1][c] = a;
					}
				} else if (sheet.getRow(r).getCell(c).getCellType() == CellType.STRING) {
					data[r - 1][c] = sheet.getRow(r).getCell(c).getStringCellValue();
				} else if (sheet.getRow(r).getCell(c).getCellType() == CellType.BOOLEAN) {
					data[r - 1][c] = sheet.getRow(r).getCell(c).getBooleanCellValue();
				} else {
					data[r - 1][c] = format.formatCellValue(sheet.getRow(r).getCell(c));
				}
			}
		}
		book.close();
		file.close();

		return data;
	}

}
