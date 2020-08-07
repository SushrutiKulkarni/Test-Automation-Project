import static org.testng.AssertJUnit.assertEquals;

//import java.util.Iterator;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {
	
	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create object for chrome browser
		//Strictly implement methods of webdriver interface
		//Invoke .exe file
		System.setProperty("webdriver.chrome.driver","C:\\Browser drivers\\chromedriver.exe" );
		
		WebDriverManager.chromedriver().setup();
		
		
		//1. Open up a browser windows and navigate to 'https://www.google.ca/'
	    driver.get("https://www.google.ca/");
		
		//2. Enter 'PayBright' in google search and click on Google Search button
		WebElement element = driver.findElement(By.xpath("//*[@name='q']"));
		element.sendKeys("PayBright");
		element.submit();
		
		//Verify google search text
		System.out.println("Current title is :" + driver.getTitle());
		driver.manage().window().maximize();
		
		//3. Verify that "paybright.com" is present on the screen
		/*if(driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a/div/cite"))!= null){
			System.out.println("paybright.com is present on the screen");
			}else{
			System.out.println("paybright.com is absent");
			}*/
		Assert.assertTrue(isElementPresent(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a/div/cite")),"Link is not present!");
		//new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a/div/cite")))){
		System.out.println("paybright.com is present on the screen");
		
		//4. Navigate to 'https://paybright.com/en/' and verify PayBright website is loaded
		driver.navigate().to("https://paybright.com/en/");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL,"https://paybright.com/en/");
		System.out.println("PayBright website is loaded successfully!");
		
	
		//System.out.println("Current title is :" + driver.getCurrentUrl());
		
		//5. Navigate to 'https://paybright.com/en/shop-directory'
		driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/header/div/div/div/div/div[2]/div/div/nav/ul/a[1]")).click();
		String VURL = driver.getCurrentUrl();
		Assert.assertEquals(VURL,"https://paybright.com/en/shop-directory");
		System.out.println("Navigated successfully to Shop Directory!");
		//Did not click on the Shop button because it generated a query endpoint url which does not match the requirement.
		
		//6. Choose 'Popular' in the 'Sort By' dropdown and enter 'samsung' in the search box
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mui-component-select-sort-by']")));
		driver.findElement(By.xpath("//*[@id='mui-component-select-sort-by']")).click();
		//Select listbox = new Select(driver.findElement(By.xpath("//*[@id='menu-sort-by']/div[3]/ul")));
		//listbox.selectByValue("Popular");
		driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li[2][@data-value='volume_DESC']")).click();
		/*((JavascriptExecutor)driver).executeScript("arguments[0].click;", driver.findElement(By.linkText("Popular")));
		List<WebElement> lst = driver.findElements(By.xpath("//*[@id='menu-sort-by']/div[3]/ul"));
		for(WebElement lsts :lst) {
			if ("Popular".equals(((WebElement) lst).getText())) {
			((WebElement) lst).click();
			}
			}
		//lst.get(1).click();
		/*Iterator<WebElement> it = lst.iterator();
		while (it.hasNext()) 
		   {
		    WebElement wb  = it.next();
		    if(wb.getText().equals(<Text to find in double quotes>)) {
		        wb.click();
		        break;
		    }*/

	//Select dropsortby = new Select(driver.findElement(By.xpath("//*[@id='mui-component-select-sort-by']")));
		//dropsortby.selectByVisibleText("Popular");
		//driver.findElement(By.xpath("//*[@id='#top']/div[1]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div")).click();*/
		
		WebElement element1 = driver.findElement(By.xpath("//*[@id='#top']/div[1]/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/input"));
		element1.sendKeys("samsung");
		element1.sendKeys(Keys.ENTER);
		
		//7. Verify that "Samsung" is present in the search results
		JavascriptExecutor js = (JavascriptExecutor) driver;

        //Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.xpath("//*[@id='#top']/div[3]/div/div[2]/div/div/div/div/a/div[2]/p[2]"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='#top']/div[3]/div/div[2]/div/div/div/div/a/div[2]/p[2]")),"Element is not present, test failed :(");
		System.out.println("Test case Passed, Samsung present in search results!");
		//Tear down
		driver.quit();
	}

	public static boolean isElementPresent(By xpath) {
    	 
		
		try{
			
			driver.findElement(xpath);
			return true;
			
		}catch(NoSuchElementException e) {
			return false;
		
		}

	}
	
}


