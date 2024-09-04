package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}

	
	//Locators
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath= "//span[normalize-space()='Checkout']")
	WebElement lnkCheckout;
	
	@FindBy(xpath="//a[normalize-space()='iPhone']")
	WebElement clickiphone;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement clickLogin;
	
	
	// action methods
	
	public void clickMyAccount() {
		
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		
		lnkRegister.click();
	}
	
	public void clickCheckout() {
		
		lnkCheckout.click();
	}
	
	public void clickIphone() {
		
		clickiphone.click();
	}
	
	public void clickLogin() {
		
	clickLogin.click();
	}
}
