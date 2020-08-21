package com.pba.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pba.base.TestBase;

public class Testcase1 extends TestBase{
	
	@Test
	public void testCase() throws InterruptedException{

		log.debug("Inside TestCase1!");
		//2. Enter 'PayBright' in google search and click on Google Search button
		WebElement element = driver.findElement(By.xpath(OR.getProperty("GoogleSearch")));
		element.sendKeys("PayBright");
		element.submit();
		
		//Verify google search text
		log.debug("Current title is :" + driver.getTitle());
		
		//3. Verify that "paybright.com" is present on the screen
				/*if(driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a/div/cite"))!= null){
					System.out.println("paybright.com is present on the screen");
					}else{
					System.out.println("paybright.com is absent");
					}*/
				Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("Link"))), "Link is absent!");
				//new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a/div/cite")))){
				log.debug("www.paybright.com is present on the screen!");
				
				//4. Navigate to 'https://paybright.com/en/' and verify PayBright website is loaded
				driver.navigate().to(config.getProperty("testsiteurl2"));
				String URL = driver.getCurrentUrl();
				Assert.assertEquals(URL,"https://paybright.com/en/");
				log.debug("Current title is :" + driver.getTitle());
				
				//5. Navigate to 'https://paybright.com/en/shop-directory'
				driver.findElement(By.xpath(OR.getProperty("Shop"))).click();
				String VURL = driver.getCurrentUrl();
				Assert.assertEquals(VURL,"https://paybright.com/en/shop-directory");
				log.debug("Navigated sucessfully to " + driver.getTitle());
				
				//6. Choose 'Popular' in the 'Sort By' dropdown and enter 'samsung' in the search box
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("SortBy"))));
				driver.findElement(By.xpath(OR.getProperty("SortBy"))).click();
				driver.findElement(By.xpath(OR.getProperty("DD2"))).click();//Relative xpath
				
				WebElement element1 = driver.findElement(By.xpath(OR.getProperty("Search")));
				element1.sendKeys("samsung");
				element1.sendKeys(Keys.ENTER);
				//Security test
				String VURL1 = driver.getCurrentUrl();
				Assert.assertEquals(VURL1, "https://paybright.com/en/shop-directory?category=&sortBy=volume_DESC&search=samsung&false");
				log.debug("Sorted and searched correctly !! ");
				
				//7. Verify that "Samsung" is present in the search results
				JavascriptExecutor js = (JavascriptExecutor) driver;

		        //Find element by link text and store in variable "Element"        		
		        WebElement Element = driver.findElement(By.xpath(OR.getProperty("SearchResult")));

		        //This will scroll the page till the element is found		
		        js.executeScript("arguments[0].scrollIntoView();", Element);
		        
		        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("SearchResult"))),"Element is not present, test failed :(");
				log.debug("Test case Passed, Samsung present in search results!");

		
		Reporter.log("Test case Passed, Samsung present in search results!");

	}

}
