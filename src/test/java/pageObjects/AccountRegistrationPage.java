package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtCnfrmPssword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	
	
	//action methods
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhone(String phone) {
		txtTelephone.sendKeys(phone);
	}
	
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void setConfrmPassword(String confrmpass) {
		txtCnfrmPssword.sendKeys(confrmpass);
	}
	
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
		
		// btnContinue.submit();
		
//		Actions actions = new Actions(driver);
//		actions.moveToElement(btnContinue).click().perform();
//		
//		btnContinue.sendKeys(Keys.RETURN);
		
	}
	
	
	
	
	
	
}
