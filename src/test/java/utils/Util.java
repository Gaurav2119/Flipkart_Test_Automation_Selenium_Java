package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Util {

	public static String generateCurrentDateAndTime() {
		return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
	}

	public static List<String> testToBeExecuted() {
		ExcelLoader el = new ExcelLoader("src/test/resources/datafile.xlsx", "TestExecutor");

		return el.getTestClassesToRun(el.getRowCount());
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelLoader el = new ExcelLoader("src/test/resources/datafile.xlsx", "TestData");
		
		int rowCount = el.getRowCount();
		int colCount = el.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i=1; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				String cellData = el.getCellDataString(i,j);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}
}
