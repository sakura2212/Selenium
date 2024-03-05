package basicddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class test3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\skillrary.xlsx");
		Workbook wb = WorkbookFactory.create(fis) ;
		Sheet sh1 = wb.getSheet("Sheet1") ;
		Row r1 = sh1.createRow(3) ;
		Cell c1 = r1.createCell(0) ;
		c1.setCellValue("Varsha");
		
		FileOutputStream fos = new FileOutputStream("src\\test\\resources\\skillrary.xlsx");
		wb.write(fos);
		
		

	}

}
