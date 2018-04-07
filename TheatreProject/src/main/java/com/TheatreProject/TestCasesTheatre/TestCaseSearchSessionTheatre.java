package com.TheatreProject.TestCasesTheatre;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TheatreProject.PageObjectTheatre.SearchSession;
import com.TheatreProject.PageObjectTheatre.SearchStaff;


public class TestCaseSearchSessionTheatre{
	
	//ExtentReports extent;
	//ExtentTest logger;

protected WebDriver driver;
SearchStaff objSearch;

/*@BeforeSuite
public void beforeSuit()
{
	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport1.html", true);
}

@BeforeMethod
public void beforeMethod(Method method)
{
	ExtentTest test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()),method.getName());
	test.assignAuthor("Sachin Ahlawat");
}*/


@BeforeTest

public void setup(){

		driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://hot_healthscope:9000/main/theatre/session");

        //extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	}

@Test(alwaysRun = true)

public  void test_SearchSession() throws InterruptedException {
	SearchSession objSearch1 = new SearchSession(driver);
	objSearch1.setLocation("Burwood");
	Thread.sleep(1000);
	objSearch1.setTheatreName("Theatre 3");
	Thread.sleep(1000);
	objSearch1.setDateFrom("01/MAR/2018");
	Thread.sleep(1000);
	objSearch1.setDateTo("18/MAR/2018");
	Thread.sleep(1000);
	objSearch1.setSessionType("All");
	objSearch1.setStaffStatus("All");
	objSearch1.clickSearch();
}
	
	
@Test(alwaysRun = true)
public void test_SearchSessionMandatoryFields() throws InterruptedException {
	SearchSession objSearch2 = new SearchSession(driver);
	objSearch2.setLocation("Burwood");
	Thread.sleep(1000);
	objSearch2.setTheatreName("Theatre 3");
	Thread.sleep(1000);
	objSearch2.setDateFrom("");
	Thread.sleep(1000);
	objSearch2.setDateTo("");
	Thread.sleep(1000);
	objSearch2.setSessionType("All");
	objSearch2.setStaffStatus("All");
	objSearch2.clickSearch();
	objSearch2.valDateFrom("This field is required.");
	objSearch2.valDateTo("This field is required.");
}
	
@Test(alwaysRun = true)
public void test_ValNoSessionFound() throws InterruptedException {
	SearchSession objSearch3 = new SearchSession(driver);
	objSearch3.setLocation("Burwood");
	Thread.sleep(1000);
	objSearch3.setTheatreName("Theatre 3");
	Thread.sleep(1000);
	objSearch3.setDateFrom("01/Mar/2018");
	Thread.sleep(1000);
	objSearch3.setDateTo("01/Mar/2018");
	Thread.sleep(1000);
	objSearch3.setSessionType("All");
	objSearch3.setStaffStatus("All");
	objSearch3.clickSearch();
	objSearch3.valNoSessonFound("No Session Found");
	
}
	
@Test(alwaysRun = true)
public void test_ValMandatoryNonMandatorySessionSaerch() throws InterruptedException {
	SearchSession objSearch4 = new SearchSession(driver);
	objSearch4.setLocation("Burwood");
	Thread.sleep(1000);
	objSearch4.setTheatreName("Theatre 3");
	Thread.sleep(1000);
	objSearch4.setDateFrom("01/Mar/2018");
	Thread.sleep(2000);
	objSearch4.setDateTo("01/Mar/2018");
	Thread.sleep(1000);
	objSearch4.setSessionType("AM");
	objSearch4.setStaffStatus("Allocated");
	objSearch4.clickSearch();
	objSearch4.valNoSessonFound("No Session Found");
	
}
	

@AfterTest
public void close() {
		
	driver.close();
	//extent.flush();
}

}