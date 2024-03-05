package basicddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//data driven testing =>ddt
public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//driver.get("https://demoapp.skillrary.com/");

		// 1. create object of FileInputStream class to read data
		// & in FileInputStream () constructor add file path / location of file
		FileInputStream fis = new FileInputStream("src\\test\\resources\\data.properties");

		// 2.create object of properties class
		Properties p = new Properties();

		// 3.call load() to fetch locatn of external file
		p.load(fis);

		// 4. call getProperty(Stirng key) to fetch the keys
		// keys are case-sensitive
		String url = p.getProperty("Url") ;
		String email = p.getProperty("Email");
		String pass = p.getProperty("Password");

		driver.get(url) ;
		 driver.findElement(By.linkText("LOGIN")).click() ;
		 driver.findElement(By.id("email")).sendKeys(email) ;
		 driver.findElement(By.id("password")).sendKeys(pass) ;
		 
	}
//launch fb=> email => pwd using ddt
}
