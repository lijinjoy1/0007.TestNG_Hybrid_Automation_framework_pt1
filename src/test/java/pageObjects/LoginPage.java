package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement clickLogin;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccountLabel;
	
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement clickMyAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement clickLogout;
	
	//action methods
	public void addLogin (String email) {
		
		txtEmailField.sendKeys(email);
	}
	
	public void addPassword (String pass) {
		
		txtPasswordField.sendKeys(pass);
	}
	
	public void btnLogin () {
		
		clickLogin.click();
	}
	
	public String checkMyAccountLabel () {
		
		return MyAccountLabel.getText();
	}
	
	
	public void btnMyAccount () {
		
		clickMyAccount.click();
	}
	
	public void btnLogOut () {
		
		clickLogout.click();
	}
	
}
