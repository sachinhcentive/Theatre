package com.TheatreProject.TestCasesTheatre;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.TheatreProject.PageObjectTheatre.SessionType;

public class TestCaseSessionType{
	protected WebDriver driver;
	SessionType objSessionType;
	
	
	
	
	
	@BeforeTest

	public void setup(){

			driver = new FirefoxDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        driver.manage().window().maximize();

	        driver.get("http://hot_healthscope:9000/main/theatre/sessiontype");
	        
	}
@Test(alwaysRun = true)
public void test_CreateNewSessionType() throws InterruptedException {
	
	objSessionType= new SessionType(driver);
	Thread.sleep(2000);
	objSessionType.clickAddSessionType();
	objSessionType.txtSessionName("Test Session Type");
	objSessionType.txtStartTime("14:00");
	objSessionType.txtEndTime("16:00");
	Thread.sleep(2000);
	objSessionType.clickSave();
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER);

	//Thread.sleep(3000);
	
	
}

/*@Test
public void test_DeleteSessionType() throws InterruptedException
{
	
 SessionType objSessionTypeDelete= new SessionType(driver);
 Thread.sleep(2000);
 objSessionTypeDelete.clickDeletePanel();
 objSessionTypeDelete.clickSessionDelete();
 objSessionTypeDelete.clickDeleteSessionTypeDialogueBox();
 

}*/
@AfterTest
public void close() {
	
	driver.close();
	//extent.flush();
}
}