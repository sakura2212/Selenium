package basicPom2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
import pom.LoginPage;
import pom2.ContactHomePage;
import pom2.ContactInformationPage;
import pom2.ContactLoginPage;
import pom2.ContactPage;

public class BasePage {
	
	public static WebDriver driver ;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		PropertyFileUtil pf =new PropertyFileUtil() ;
		ExcelUtil ex =new ExcelUtil() ;
		WebDriverUtil wu = new WebDriverUtil() ;
		JavaUtil ju =new JavaUtil() ;
		
		//fetch data from vtiger.properties
		String browser = pf.getDataFromPropertyFile("Browser") ;
		String url = pf.getDataFromPropertyFile("Url") ;
		String username = pf.getDataFromPropertyFile("Username");
		String pass = pf.getDataFromPropertyFile("Password");
		
		
		//read data from excel
		//First Name
		String firstName = ex.getDataFromExcel("Contacts", 0, 1) ;
		//Last Name
		String lastName = ex.getDataFromExcel("Contacts", 1, 1) ;
		String assign = ex.getDataFromExcel("Contacts", 2, 1) ;
		//String orgName = ex.getDataFromExcel("Contacts", 3, 1) ;
		
		
		//to launch the browser
		if (browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver() ;
					
		} else if(browser.equalsIgnoreCase("Edge")) {
					driver=new EdgeDriver() ;
			}
		else {
			driver=new FirefoxDriver() ;
			}
		
		//WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
				
				//launch application
				driver.get(url);
				
				//create object of LoginPage 
				ContactLoginPage lp =new ContactLoginPage(driver) ;
				
				//login
				lp.login(username, pass);
//				PageFactory.initElements(driver, lp) ;
//				
//				lp.getUserNameTf().sendKeys(username) ;
//
//				lp.getUserPassTf().sendKeys(pass) ;
//				lp.getLoginBtn().click() ;
			
		
				//click on contacts
				
				ContactHomePage hp = new ContactHomePage(driver) ;
				//click on contact
				hp.contactHome();
//				PageFactory.initElements(driver, hp) ;
//			    hp.getContact().click();
			    
			    ContactPage cp =new ContactPage(driver) ;
			    //to create contacts
			    cp.contacts();
//			    PageFactory.initElements(driver, cp) ;
//			    cp.getCreatecontact().click();
				
			    //fill information in contact page
			    ContactInformationPage ip =new ContactInformationPage(driver) ;
			    
			    ip.contactInformation(firstName+ju.getRandomNumbers(), lastName, assign);
//			    PageFactory.initElements(driver, ip) ;
//			    
//			    //enter first name
//			    ip.getFirstName().sendKeys(firstName+ju.getRandomNumbers());
//			    
//			    //enter last name
//			    ip.getLastName().sendKeys(lastName);
//			    
//			    ip.getGrpBtn().click(); 
//			    
//			    wu.handleDropdown(ip.getDropDown(), assign);
//			    
//			    ip.getSaveBtn().click();  
				
			    Thread.sleep(2000);
				hp.contactHome(driver);
	}
			
			
}
