package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Iphonepage extends BasePage{

	//constructor
	
	public Iphonepage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement clickAddtoCart;
	
	@FindBy(xpath= "//span[normalize-space()='Shopping Cart']")
	WebElement clickShoppingCart;
	
	public void addCartIphone() {
		clickAddtoCart.click();
		
	}
	
	public void clickCheckoutiphone() {
		
		clickShoppingCart.click();
	}

}
