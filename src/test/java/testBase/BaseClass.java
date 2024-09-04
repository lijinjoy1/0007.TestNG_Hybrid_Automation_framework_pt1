package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties pro;
	
	@Parameters({"os", "browser"})
	@BeforeClass(groups={"Regression" , "Master","Sanity"})
	public void setup(String os , String br) throws IOException {
		
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		pro = new Properties();
		pro.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		
		// Selenium Grid // execution_env = remote
		if(pro.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			// Intialize remote web driver
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
			// OS
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("Linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}else {
				System.out.println("No matching OS");
				return;
			}
			
			// Browser
			switch(br.toLowerCase()) {
			
			case "edge" : 
				capabilities.setBrowserName("MicrosoftEdge"); break;
				
			case "chrome" : 
				capabilities.setBrowserName("chrome");	break;
				
			case "firefox" : 
				capabilities.setBrowserName("firefox");	break;
				
			default : System.out.println("Invalid Browser"); return;
			
			}
		}
		
		// execution_env = local
		if(pro.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			// parallel / cross browser testing  
			switch(br.toLowerCase()) {
		
			case "edge" : 
				driver = new EdgeDriver(); break;
				
			case "chrome" : 
				driver = new ChromeDriver();	break;
				
			default : System.out.println("Invalid Browser"); return;
			
			}
			
		}	
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		driver.get(pro.getProperty("appURL1"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
	}
	
public String randomString() {
		
		String generatedString =  RandomStringUtils.randomAlphabetic(5);  /// get random string
		
		return generatedString;
	}
	
	public String randomNumber() {
		
		String generatedNumeric =  RandomStringUtils.randomNumeric(5);  /// get random string
		
		return generatedNumeric;
	}
	
public String randomStringAndNumber() {
		String generatedString =  RandomStringUtils.randomAlphabetic(5);
		String generatedNumeric =  RandomStringUtils.randomNumeric(5);  /// get random string
		
		return (generatedString+ " * " +generatedNumeric);
	}

	// To capture screen shots
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // Creating time and date.
		
		TakesScreenshot takeScreenshot =  (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}

	@AfterClass(groups={"Regression" , "Master","Sanity"})
	public void tearDown() {	
		driver.quit();
	}
}
