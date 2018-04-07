package com.TheatreProject.Utility.Listeners;

import com.TheatreProject.TestCasesTheatre.TestCaseSearchStaffTheatre;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.TheatreProject.Utility.ExtentManager.*;
import com.TheatreProject.Utility.ExtentTestManager.*;
 
 
public class TestListener extends TestCaseSearchStaffTheatre implements ITestListener {
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeSuite
	public void beforeSuit()
	{
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport1.html", true);
	}

	@BeforeMethod
	public void beforeMethod(Method method)
	{
		ExtentTest test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()),method.getName());
		test.assignAuthor("Sachin Ahlawat");
	}
	
	
	
 
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    //Before starting all tests, below method runs.
   
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }
 
    //After ending all tests, below method runs.
    //@Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    //@Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }
 
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
 
        //Get driver from BaseTest and assign to local webdriver variable.
       //Object testClass = iTestResult.getInstance();
      //WebDriver webDriver =  (WebDriver) testClass;
 
        //Take base64Screenshot screenshot.
       // String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                //getScreenshotAs(OutputType.BASE64);
 
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed");
                //ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
 
    @AfterTest
    public void close() {
    	
    	
    	
    	driver.close();
    	extent.flush();
    }
    
}