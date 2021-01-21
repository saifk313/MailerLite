package com.mailerlite.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * This class is designed to include all the utilities properties and methods 
 * which will be required by the application in order to run the tests 
 * 
 */

public class TestUtil {

	static XSSFWorkbook book;
	static XSSFSheet sheet;

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Dell\\eclipse-workspace\\MailerLiteAutomation\\src\\main\\java\\com\\mailerlite\\qa\\testData\\credentials.xlsx";

	public static Object[][] readDatafromExcel(String sheetName) {
		try {
			File src = new File(TESTDATA_SHEET_PATH);
			FileInputStream fis = new FileInputStream(src);
			book = new XSSFWorkbook(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][columnCount];

		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				data[row][column] = sheet.getRow(row + 1).getCell(column).toString();
			}
		}
		return data;
	}
}
