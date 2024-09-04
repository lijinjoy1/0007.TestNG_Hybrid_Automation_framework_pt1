package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC04_VerifyLogin extends BaseClass{
	

	@Test(groups="Sanity")
	public void VerifyLogin() {
		
		logger.info(" ******** Starting TC04_VerifyLogin test ******** ");
	try {	
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		logger.info(" Clicked on Myaccount ");
		home.clickLogin();
		logger.info(" Clicked on Login ");
		
		
		LoginPage login = new LoginPage(driver);
		login.addLogin(pro.getProperty("email"));
		logger.info(" Email  ");
		login.addPassword(pro.getProperty("password"));
		logger.info(" password  ");
		login.btnLogin();
		Thread.sleep(3000);
		
		login.btnMyAccount();
		login.btnLogOut();
		
		}catch(Exception e) {
			
			logger.error("Test failed");
			logger.debug("Debug Log");
			Assert.fail();
		}
		
	}
	

}
