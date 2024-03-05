package basicddt;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import commonUtils.ExcelUtil;
import commonUtils.PropertyFileUtil;

public class test2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		ExcelUtil e1 = new ExcelUtil() ;
		//e1.getDataFromExcel("Sheet1", 0, 0) ;
		//e1.getDataFromExcel("Sheet1", 0, 1) ;
		System.out.println(e1.getDataFromExcel("Sheet1", 0, 0) );
		System.out.println(e1.getDataFromExcel("Sheet1", 0, 1) );

		//stored path in var passed in constructor
		PropertyFileUtil p1=new PropertyFileUtil() ;
		//System.out.println(p1.getDataFromPropertyFile("Url") );
		
		//call method propertyfile => enter email password
	}

}
