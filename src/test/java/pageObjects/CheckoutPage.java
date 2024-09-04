package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
	
	public CheckoutPage(WebDriver driver) {
		
		super (driver);
	}
	
	// Locators
	
	
	
	@FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	WebElement txtCheckout;

	
	//action methods
		public String CheckTextCheckout() {
			String check = txtCheckout.getText();
			return  check;
		}
		
		

}
