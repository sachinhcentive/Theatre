package com.TheatreProject.TestCasesTheatre;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TheatreProject.PageObjectTheatre.CreateSession;
import com.TheatreProject.PageObjectTheatre.SearchSession;
import com.TheatreProject.PageObjectTheatre.SessionType;

public class TestCaseCreateSession{
	
	WebDriver driver;
	//SearchSession objSearchSession;
	
	@BeforeTest

	public void setup(){

			driver = new FirefoxDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        driver.manage().window().maximize();

	        driver.get("http://hot_healthscope:9000/main/theatre/session");
	        
	}
	
@Test(alwaysRun = true)
public void test_CreateNewSession() throws InterruptedException {

		CreateSession objCreateSession= new CreateSession(driver);
		SearchSession objSearchSession= new SearchSession(driver);
		Thread.sleep(2000);
		objCreateSession.btnCreateSession();
		objSearchSession.setLocation("Burwood");
		objSearchSession.setTheatreName("Theatre 1");
		Thread.sleep(2000);
		objCreateSession.selectDate();
		objCreateSession.chkSessionType();
		objCreateSession.btnSaveSession();
		Thread.sleep(2000);
}

@Test(alwaysRun = true)
public void test_DeleteCreatedSession() throws InterruptedException
{
	
		SearchSession objSearch1 = new SearchSession(driver);
		CreateSession objCreateSession2= new CreateSession(driver);
		
		objSearch1.setLocation("Burwood");
		Thread.sleep(1000);
		objSearch1.setTheatreName("Theatre 1");
		Thread.sleep(1000);
		objSearch1.setDateFrom("01/MAR/2018");
		Thread.sleep(1000);
		objSearch1.setDateTo("30/MAR/2018");
		Thread.sleep(1000);
		objSearch1.setSessionType("All");
		objSearch1.setStaffStatus("All");
		objSearch1.clickSearch();
		Thread.sleep(2000);
		objCreateSession2.clkDeleteSessionPanel();
		Thread.sleep(2000);
		objCreateSession2.btnDeletePanelSession();
		
		Thread.sleep(2000);
		objCreateSession2.btnDeleteDialogueBox();
	

	
}
@Test(alwaysRun = true)
private void test_DeleteSessionType1() throws InterruptedException {
		driver = new FirefoxDriver();
	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.manage().window().maximize();
	
	    driver.get("http://hot_healthscope:9000/main/theatre/sessiontype");
		SessionType objSessionTypeDelete= new SessionType(driver);
		 Thread.sleep(2000);
		 objSessionTypeDelete.clickDeletePanel();
		 objSessionTypeDelete.clickSessionDelete();
		 objSessionTypeDelete.clickDeleteSessionTypeDialogueBox();
	
}

@AfterTest
public void close() {
	
	driver.close();
	//extent.flush();
}
}