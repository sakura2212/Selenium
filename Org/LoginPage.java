package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//identify username tf
	@FindBy (name="user_name")
	private WebElement userNameTf;
	
	//identify password tf
	@FindBy (name="user_password")
	private WebElement userPassTf;
	
	//identify login button
	@FindBy (id="submitButton")
	private WebElement loginBtn;

	public WebElement getUserNameTf() {
		return userNameTf;
	}	

	public WebElement getUserPassTf() {
		return userPassTf;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//create constructor to initialized webelement
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this) ;
		//this will hold the refr of LoginPage object
	}
	
	//create method => to perform the action
	public void login(String username,String password)
	{
		userNameTf.sendKeys(username);
		userPassTf.sendKeys(password);
		loginBtn.click();
	}
	
	
}
