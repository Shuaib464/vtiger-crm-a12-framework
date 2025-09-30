package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// Get the Java Representation Object of Excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/TestScriptData.xlsx");
		
		// Open excel file in Read Mode
		Workbook wb = WorkbookFactory.create(fis);
		
		// get the Sheet
		Sheet sh = wb.getSheet("MySheet");
		
		//get the row
		Row rw = sh.getRow(4);
		
		// Get The cell
		Cell cell = rw.getCell(1);
		
		// Fetch the Cell data
		String data = cell.getStringCellValue();
		
		System.out.println("Cell data value is : " + data);
		
		
	}

}
