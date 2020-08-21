/*package com.pba.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pba.base.TestBase;

public class TestUtil extends TestBase {
	
	public static String screenshotpath;
	
	public static String screenshotname;
	
	public static void captureScreenshot() throws IOException{
		
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		screenshotname = "error.jpg";
		
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotname+".jpg"));
	}
	

}*/
