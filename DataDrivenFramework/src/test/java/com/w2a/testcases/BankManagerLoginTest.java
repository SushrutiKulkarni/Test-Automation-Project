package com.w2a.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException{
		
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("Bmlbtn"))).click();
		//Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustomerBtn"))),"Login not successfull!");
		log.debug("Login successfully executed!");
		
	}
	
}
