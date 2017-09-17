package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadKeywords {

	public String[][] readKeywords(String path) {
		String[][] xTCdata = null;
		File myxl = new File(path);
		try {
			FileInputStream myStream = new FileInputStream(myxl);

			HSSFWorkbook myWB = new HSSFWorkbook(myStream);
			HSSFSheet mySheet = myWB.getSheet("Test1"); // Referring to 1st sheet
			int xTCRows = mySheet.getLastRowNum() + 1;
			int xTCCols = mySheet.getRow(0).getLastCellNum();
			System.out.println("Rows are " + xTCRows);
			System.out.println("Cols are " + xTCCols);
			xTCdata = new String[xTCRows][xTCCols];
			for (int i = 0; i < xTCRows; i++) {
				HSSFRow row = mySheet.getRow(i);
				for (int j = 0; j < xTCCols; j++) {
					HSSFCell cell = row.getCell(j); // To read value from each col in each row
					if (cell != null) {
						String value = cellToString(cell);
						xTCdata[i][j] = value;
					}
				}
			}
			myWB.close();
		} catch (FileNotFoundException fe) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("File Not Found");
		}

		return xTCdata;
	}

	public static String cellToString(HSSFCell cell) {
		// This function will convert an object of type excel cell to a string value

		int type = cell.getCellType();
		Object result;
		switch (type) {
		case HSSFCell.CELL_TYPE_NUMERIC: // 0
			result = cell.getNumericCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING: // 1
			result = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_FORMULA: // 2
			throw new RuntimeException("We can't evaluate formulas in Java");
		case HSSFCell.CELL_TYPE_BLANK: // 3
			result = "-";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN: // 4
			result = cell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_ERROR: // 5
			throw new RuntimeException("This cell has an error");
		default:
			throw new RuntimeException("We don't support this cell type: " + type);
		}
		return result.toString();
	}
}
