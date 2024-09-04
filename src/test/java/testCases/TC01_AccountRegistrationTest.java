package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass{
		
	@Test(groups={"Regression" , "Master","sanity"})
	public void verify_account_registeration() {
		
		logger.info(" ******** Starting TC01_AccountRegistrationTest ******** ");
	
	try {
		HomePage home = new HomePage(driver);
		
		home.clickMyAccount();
		logger.info(" Clicked on Myaccount ");
		home.clickRegister();
		logger.info(" Clicked on Resgister option ");
		
		
//		AccountRegistrationPage actRegstrpage = new AccountRegistrationPage(driver);
//		actRegstrpage.setFirstName("arun");
//		actRegstrpage.setLastName("david");
//		actRegstrpage.setEmail("abc@gmail.com");
//		actRegstrpage.setPhone("78979678");
//		actRegstrpage.setPassword("arun");
//		actRegstrpage.setConfrmPassword("arun");
//		actRegstrpage.setPrivacyPolicy();
//		actRegstrpage.clickContinue();
		
		AccountRegistrationPage actRegstrpage = new AccountRegistrationPage(driver);
		actRegstrpage.setFirstName(randomString());
		actRegstrpage.setLastName(randomString());
		actRegstrpage.setEmail(randomString()+"@gmail.com");
		actRegstrpage.setPhone(randomNumber());
		
		
		String password =  randomStringAndNumber();
		actRegstrpage.setPassword(password);
		actRegstrpage.setConfrmPassword(password);
		
		
		actRegstrpage.setPrivacyPolicy();
		actRegstrpage.clickContinue();
	
	}catch(Exception e) {
		logger.error("Test Case failed");
		logger.debug("ebug files");
		Assert.fail();
	}
	
	logger.info(" ******** Finished TC01_AccountRegistrationTest ******** ");
	
	}	
}
