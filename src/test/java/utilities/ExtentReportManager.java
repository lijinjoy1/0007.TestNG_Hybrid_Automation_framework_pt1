package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest tests;
	
	String repName;
	
	public void onStart(ITestContext context) { // common information details
		
		/* 
		 SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String timeStamp = df.format(dt); 
		*/ //        OR
			
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Creating time and date.
		repName = "Test-Report- " + timeStamp + ".html";                                   // Report name.
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);  // specify the location
		
		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // Title of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // Name of the report
		sparkReporter.config().setTheme (Theme.DARK);                        // Theme
		
		// Documents
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("Application", "opencart");
		reports.setSystemInfo("Module", "Admin");
		reports.setSystemInfo("Sub Module", "Customers");
		
		reports.setSystemInfo("User name", System.getProperty("user.name"));   // tester name
		reports.setSystemInfo("Environment", "QA");
		
		String os = context.getCurrentXmlTest().getParameter("os");
		reports.setSystemInfo("Operating System", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		reports.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		reports.setSystemInfo("Groups", includedGroups.toString());
			}
		
		}
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("test case started.....");
		
	  }
		
		
	public void onTestSuccess(ITestResult result) 
		{
			tests = reports.createTest(result.getTestClass().getName()); // Create a new entry in the report
			tests.assignCategory(result.getMethod().getGroups());       // to display groups in the report
			tests.log(Status.PASS, result.getName() + "got successfully executed");// update status
		
		}	
		
	public void onTestFailure(ITestResult result) 
			{
				
				tests = reports.createTest(result.getTestClass().getName());
				tests.assignCategory(result.getMethod().getGroups());
				
				tests.log(Status.FAIL, result.getName() + "got failed");
				tests.log(Status.INFO, result.getThrowable().getMessage());
			    
			    try
			    {
			    	String imgPath = new BaseClass().captureScreen(result.getName());
			    	tests.addScreenCaptureFromPath(imgPath);
			    }
			    catch(Exception e)
			    {
			    	e.printStackTrace();
			    }
			    
			}
				
			
		public void onTestSkipped(ITestResult result)
			
			{
			
				tests = reports.createTest(result.getTestClass().getName());
				tests.assignCategory(result.getMethod().getGroups());
				
				tests.log(Status.SKIP, result.getName() + "got skipped");
			    tests.log(Status.INFO, result.getThrowable().getMessage());
			
			}
			
			
			
		public void onFinish(ITestContext testContext)
			{
				
			reports.flush();
			
			// To Open report automatically.
			String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
			File extentReport = new File(pathOfExtentReport);
			
			try
			{
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
		
		// To send report email automatically.
		
//			try {
//				
//				URL url = new URL("file:///"+ System.getProperty("user.dir") + "\\reports\\" + repName);
//				
//				// create email
//				ImageHtmlEmail email = new ImageHtmlEmail();
//				
//				email.setDataSourceResolver(new DataSourceUrlResolver(url));
//				email.setHostName("smtp.googlegmail.com");
//				email.setSmtpPort(465);
//				email.setAuthenticator(new DefaultAuthenticator("lijinjoy1@gmail.com" , "password"));
//				email.setSSLOnConnect(true);
//				email.setFrom("lijinjoy1@gmail.com"); // Sender
//				email.setSubject("Test Reports");
//				email.setMsg("Please find the attached report");
//				email.addTo("lijinjoy1@gmail.com");  // Recevier
//				email.attach(url ,"extent report" , "please check");
//				email.send();	
//			}catch(Exception  e) {
//				
//				e.printStackTrace();
//			}
//		
//			}
			}
}
