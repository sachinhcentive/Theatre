package com.TheatreProject.TestCasesTheatre;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TheatreProject.PageObjectTheatre.SearchStaff;
import com.TheatreProject.Utility.RandomeNumber;



public class TestCaseSearchStaffTheatre{
	
	//ExtentReports extent;
	//ExtentTest logger;

protected WebDriver driver;
SearchStaff objSearch;



@BeforeTest

public void setup(){

		driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://hot_healthscope:9000/main/theatre/staff");

        //extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	}


@Test(alwaysRun = true)

public void test_SearchStaff() throws InterruptedException
{
	//logger=extent.startTest("Test_Mandatory_Fields");
	objSearch = new SearchStaff(driver);
	
	objSearch.setLastName("t");
	objSearch.setFirstName(null);
	objSearch.setRole("Theatre Technician");
	objSearch.setTeam("Team 2");
	Thread.sleep(2000);
	objSearch.clickSearch();
	
	//logger.log(LogStatus.PASS, "Test case Pass");
}

@Test(alwaysRun = true)
public void test_Mandatory_Fields() throws InterruptedException
{
	//logger=extent.startTest("Test_Mandatory_Fields");
	SearchStaff objSearch1 = new SearchStaff(driver);
	
	objSearch1.setLastName(null);
	objSearch1.setFirstName(null);
	objSearch1.setRole("Theatre Technician");
	objSearch1.setTeam("Team 2");
	Thread.sleep(2000);
	objSearch1.clickSearch();
	objSearch1.validationSearchStaff("This field is required");
	
	//logger.log(LogStatus.PASS, "Test case Pass");
}

/*@AfterMethod
public void getResult(ITestResult result){
	if(result.getStatus() == ITestResult.FAILURE){
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	}else if(result.getStatus() == ITestResult.SKIP){
		logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	}
	// ending test
	//endTest(logger) : It ends the current test and prepares to create HTML report
	extent.endTest(logger);
}*/

@Test(alwaysRun = true)
public void test_NoRecordFound() throws InterruptedException {
	
	SearchStaff objSearch2 = new SearchStaff(driver);
	
	objSearch2.setLastName("z");
	objSearch2.setFirstName(null);
	objSearch2.setRole("Theatre Technician");
	objSearch2.setTeam("Team 2");
	Thread.sleep(2000);
	objSearch2.clickSearch();
	objSearch2.validationNoRecordFound("No Record Found");
}

@Test(alwaysRun = true)
public void test_ViewButtonSaveNewTeam() throws InterruptedException {
	
	String number;
	
	RandomeNumber valValue = new RandomeNumber();
	number=valValue.RandomNumber();
	SearchStaff objSearch3 = new SearchStaff(driver);
	
	objSearch3.setLastName("t");
	objSearch3.setFirstName(null);
	objSearch3.setRole("Any Role");
	objSearch3.setTeam("Any Team");
	Thread.sleep(2000);
	objSearch3.clickSearch();
	Thread.sleep(2000);
	objSearch3.ClickView();
	Thread.sleep(2000);
	objSearch3.ClickNewTeam();
	Thread.sleep(2000);
	objSearch3.setNewTeamName(number);
	objSearch3.ClickNewTeamSave();
	Thread.sleep(2000);
	objSearch3.clickSave();
	//Thread.sleep(2000);
}

@Test(alwaysRun = true)
public void test_UnChkRoleTeam() throws InterruptedException {
	
SearchStaff objSearch4 = new SearchStaff(driver);

	objSearch4.setLastName("t");
	objSearch4.setFirstName(null);
	objSearch4.setRole("Any Role");
	objSearch4.setTeam("Any Team");
	Thread.sleep(2000);
	objSearch4.clickSearch();
	Thread.sleep(2000);
	objSearch4.ClickView();
	Thread.sleep(2000);
	objSearch4.chkCheckAllCheckbox();
	Thread.sleep(2000);
	objSearch4.clickSave();
	//objSearch4.valdiateRole(null);
	
}

@Test(alwaysRun = true)
public void test_ChkRoleTeam() throws InterruptedException {
	
	SearchStaff objSearch5 = new SearchStaff(driver);
		
	objSearch5.setLastName("t");
	objSearch5.setFirstName(null);
	objSearch5.setRole("Any Role");
	objSearch5.setTeam("Any Team");
	Thread.sleep(2000);
	objSearch5.clickSearch();
	Thread.sleep(2000);
	objSearch5.ClickView();
	objSearch5.setCheckBoxValue("Anaesthetic Nurse");
	Thread.sleep(2000);
	objSearch5.clickSave();
	Thread.sleep(2000);
	objSearch5.setLastName("t");
	objSearch5.setFirstName(null);
	objSearch5.setRole("Any Role");
	objSearch5.setTeam("Any Team");
	Thread.sleep(2000);
	objSearch5.clickSearch();
	Thread.sleep(2000);
	objSearch5.ClickView();
	Thread.sleep(2000);
	objSearch5.setCheckBoxValue("Team 1");
	Thread.sleep(2000);
	objSearch5.clickSave();
	
}

@AfterTest
public void close() {
	
	driver.close();
	//extent.flush();
}



public void onFinish(ITestContext iTestContext) {
	// TODO Auto-generated method stub
	
}

public void onTestStart(ITestResult iTestResult) {
	// TODO Auto-generated method stub
	
}

public void onStart(ITestContext iTestContext) {
	// TODO Auto-generated method stub
	
}

public void onTestSuccess(ITestResult iTestResult) {
	// TODO Auto-generated method stub
	
}

public void onTestFailure(ITestResult iTestResult) {
	// TODO Auto-generated method stub
	
}

public void onTestSkipped(ITestResult iTestResult) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	// TODO Auto-generated method stub
	
}



}