package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC02_VerifyCheckout extends BaseClass {
	
	
	@Test(groups="Master")
	public void verify_checkout() {
		
		logger.info("****** TC02_VerifyCheckout started ********");
		try {
		HomePage home = new HomePage(driver);
		home.clickCheckout();
		
		CheckoutPage chkPage = new CheckoutPage(driver);
		
		String checkout  = chkPage.CheckTextCheckout();
		System.out.println(checkout);
		
		logger.info("Checking shopping cart ");
		
		if(checkout.equals("Your shopping cart is empty!")) {
			
			//Assert.assertEquals(checkout, "Your shopping cart is empty!ttt");
			Assert.assertTrue(true);
			
		}else {
			
			logger.error("Test failed");
			logger.debug("Debug log");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("****** TC02_VerifyCheckout finished ********");
		
	}

}
