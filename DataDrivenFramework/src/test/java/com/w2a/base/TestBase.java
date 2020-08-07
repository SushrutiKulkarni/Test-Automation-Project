package com.w2a.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	/* Initializing the following:
	 * WebDriver - done
	 * Properties - done
	 * Logs - Need Log4j jar, two log files, log4j.properties, Logger
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * ReportNG, ExtentReports
	 * Jenkins
	 */
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	//@BeforeMethod
	@BeforeSuite

	public void setUp() {
		if(driver == null){
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				if(config.getProperty("browser").equals("firefox")){
					//System.getProperty("webdriver.gecko.driver", "PATH OF gecko.exe");
					driver = new FirefoxDriver();
				}
				else if(config.getProperty("browser").equals("chrome")){
					
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
					driver = new ChromeDriver();
					log.debug("Chrome browser launched !!!");
				}
				else if(config.getProperty("browser").equals("ie")){
					
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				
				driver.get(config.getProperty("testsiteurl"));
				log.debug("Navigated to :"+config.getProperty("testsiteurl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
					
				}
		
		
			}
	
	public boolean isElementPresent(By by){
		
		try{
			
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e) {
			
			return false;
		}
	}
	
	//@AfterMethod
	@AfterSuite

	public void tearDown() {
		
		if(driver!=null){
			driver.quit();
		}
		
		log.debug("Test execution completed !!!");
	}

}
