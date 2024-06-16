package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLoader {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelLoader(String excelPath, String sheetName) {
		try (FileInputStream fis = new FileInputStream(excelPath)) {
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the file " + excelPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public int getColCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	public String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}

	public List<String> getTestClassesToRun(int rowCount) {
		List<String> testClasses = new ArrayList<>();

		try {
			for (int row = 1; row < rowCount; row++) {
				// Assuming "Execution Required" is in the second column
				String executionRequiredCell = sheet.getRow(row).getCell(1).getStringCellValue();
				
				if ("Yes".equalsIgnoreCase(executionRequiredCell)) {
					// Assuming test class name is in the first column
					String testClassCell = sheet.getRow(row).getCell(0).getStringCellValue();
					testClasses.add(testClassCell);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testClasses;
	}
}
