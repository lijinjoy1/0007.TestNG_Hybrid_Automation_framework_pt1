package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtilityFile;

public class TC05_LoginDataDrivernTest extends BaseClass{

	
	/* 
	 Data Valid  -- Login success --- test passed - logout --- +ve testing
	 Data Valid  -- Login failed  --- test fail
	
	 Data InValid  -- Login success --- test fail - logout --- -ve testing
	 Data InValid  -- Login failed  --- test pass
	 */
	
	
	@Test (dataProvider= "LoginData", dataProviderClass = DataProviders.class , groups ="datadriven")// getting data provider from different class
	public void LoginDataDrivernTest(String Username , String Password  ) {
		
		logger.info("****** TC05_LoginDataDrivernTest started ********");
		
		System.out.println(Username);
		System.out.println(Password);
	try {
		
		// Home Page
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		logger.info(" Clicked on Myaccount ");
		home.clickLogin();
		logger.info(" Clicked on Login ");
		
		// Login page
		LoginPage login = new LoginPage(driver);
		
		
			login.addLogin(Username);
			logger.info(" Email  ");
			
			login.addPassword(Password);
			logger.info(" password  ");
			Thread.sleep(3000);
			login.btnLogin();
		
			
			String targetPage = login.checkMyAccountLabel();
			//System.out.println(targetPage);
			
			if(targetPage.contains("My Account")) {
				System.out.println(targetPage);
				Assert.assertTrue(true);
				logger.info(" loged succesfully  ");
				login.btnMyAccount();
				login.btnLogOut();
			}else {
				Assert.assertFalse(false);
			}
			
			if(!targetPage.contains("My Account")) {
				Assert.fail();
			}
			
	}catch(Exception e) {
		logger.error("Test failed");
		logger.debug("Debug Log");
		Assert.fail();
		
	}
		logger.info("****** TC05_LoginDataDrivernTest finished ********");
	}
	
	
}
