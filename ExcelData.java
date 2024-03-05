package basicddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		/*
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 */
		
		// 1. create object of FileInputStream class to read data
				// & in FileInputStream () constructor add file path / location of file
		
		//NullPointer => when fetching row which has no data /blank cell
		//FileNotFound => wrong file path
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\skillrary.xlsx");
		
		//2.call WorkBookFactory Class 
		// two methods => create() & write()
		//for write() => FileOutputStream    For create() => FileInputStream
		
		Workbook wb = WorkbookFactory.create(fis) ;
		 
		//3. call getSheet(String) & enter Sheet name
		Sheet sh1 = wb.getSheet("Sheet1") ;
		
		//4. call getRow(int number)
		Row r1 = sh1.getRow(0);
		
		
		//5. call getCell(int cell) 
		Cell c1 = r1.getCell(0) ;
		
		//6. call getStringCellValue() 
		String data = c1.getStringCellValue() ;
		
		System.out.println(data);
		//for loop for data fetching
		
		

	}

}
