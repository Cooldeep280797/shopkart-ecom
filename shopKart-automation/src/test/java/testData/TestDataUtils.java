package testData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataUtils {
	public static Object[][] getUtilsClass(String filepath, String sheetname) throws Exception {

		FileInputStream file = new FileInputStream(new File(filepath));

		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetname);

		int rowCount = sheet.getPhysicalNumberOfRows() - 1;
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount];
		
		DataFormatter df = new DataFormatter();

		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				data[i - 1][j] = df.formatCellValue(cell);
			}
		}
		workbook.close();
		return data;
	}
}