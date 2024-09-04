package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Iphonepage;
import testBase.BaseClass;

public class TC03_IphoneCart extends BaseClass{

	
	
	@Test(groups="Sanity")
	public void verify_checkout_Iphone() throws InterruptedException {
		
		logger.info("****** TC03_IphoneCart started ********");
		
		logger.info("****** verify_checkout_Iphone ********");
		try {
			
		HomePage home = new HomePage(driver);
	    home.clickIphone();
	    
	    
	    Iphonepage iphone = new Iphonepage(driver);
	    iphone.addCartIphone();
	    iphone.clickCheckoutiphone();
	    Thread.sleep(3000);
		
		}catch(Exception e) {
			
			logger.debug("debug log");
			Assert.fail();
		}
	    
}
}