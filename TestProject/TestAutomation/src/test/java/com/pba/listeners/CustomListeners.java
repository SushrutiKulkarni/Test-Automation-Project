package com.pba.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//import com.pba.utilities.TestUtil;

public class CustomListeners implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		/*System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotname+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotname+"><img src="+TestUtil.screenshotname+" height=200 width=200></img></a>");
	*/	
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a target=\"_blank\" href=\"C:\\POM-DDF\\PayBright1.jpg\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\POM-DDF\\PayBright1.jpg\"><img src=\"C:\\POM-DDF\\PayBright1.jpg\" height=200 width=200></img></a>");
		
	}

}
