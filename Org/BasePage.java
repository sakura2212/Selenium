package basicPom;

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
import pom.HomePage;
import pom.LoginPage;
import pom.OrgInformationPage;
import pom.OrganisationPage;

public class BasePage  {

	public static WebDriver driver ;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
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
		//organisation name
		String orgName = ex.getDataFromExcel("Organisation", 0, 1) ;
		//select support group from dropdown
		String group = ex.getDataFromExcel("Organisation", 1, 1) ;
		
		
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
		LoginPage lp =new LoginPage(driver) ;
		//PageFactory.initElements(driver, lp) ; 
		
		//login to application....reading data from property file
		lp.login(username, pass);  //codeoptimization
		
//		lp.getUserNameTf().sendKeys(username) ;
//		
//		//to chck staleelementexception occurs or not
//		
//		//driver.navigate().refresh() ;
//		//lp.getUserNameTf().sendKeys("user") ;
//		
//		lp.getUserPassTf().sendKeys(pass) ;
//		lp.getLoginBtn().click() ;
		
		//create object of HomePage
		 HomePage hp =new  HomePage(driver) ;
		 //PageFactory.initElements(driver, hp) ;
		 
		 //click on organisation
		 //hp.getOrg().click() ;
		 hp.home();
		 
		 //create object of organisation
		 
		 OrganisationPage op =new OrganisationPage(driver) ;
		// PageFactory.initElements(driver, op) ;
		 //click on + to create organisation
		// op.getCreateorg().click(); 
		 op.organisations();
		 
		 //create object of organisation
	 OrgInformationPage ip =new OrgInformationPage(driver) ;
		 //PageFactory.initElements(driver, ip);
		 
		 //enter org name
		 //call getRandomNumbers() from java util to get diff org name
		// ip.getOrgInfo().sendKeys(orgName+ju.getRandomNumbers());
	 
	 ip.orgInformation(orgName+ju.getRandomNumbers(),group);
		 
		 //click on group button
		 //ip.getGrpBtn().click(); 
		 		 
		 //to select dropdown
		 //wu.handleDropdown(ip.getDropDown(), group);
		 
		 //click on save button
		 //ip.getSaveBtn().click();
		 
		 //mandotory to apply Thread.sleep before mouse hovering
		 Thread.sleep(3000);
		 //mouse hover on sign out img
		 //wu.mouseHover(driver, hp.getImg());
		 hp.home(driver);
		 
		 //click on sign out
		// hp.getSignout().click();  
		 
		 
		 

	}

}
