package com.TheatreProject.PageObjectTheatre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class SearchSession{
	
	WebDriver driver;
	//Element for Location
	 //	@FindBy(id="location")

	 //	WebElement thrLocation;
	 
	//Element for Theatre Name 
	 	//@FindBy(id="theatreName")

	 	//	WebElement thrName;
	 
	//Element for Theatre date from
	 	@FindBy(xpath="//label[(contains(text(),'Date From'))]//following-sibling::div[@class='inputElement']//input[@class='inputText']")
	 	//@FindBy(xpath="//*[@id='root']/div/div[3]/div[1]/form/div[3]/div/div/input")

	 		WebElement thrDateFrom;
	 
	 //Element for Theatre Date to
	 
	 	@FindBy(xpath="//label[(contains(text(),'Date To'))]//following-sibling::div[@class='inputElement']//input[@class='inputText']")
	 	//@FindBy(xpath="//*[@id='root']/div/div[3]/div[1]/form/div[4]/div/div/input")

	 		WebElement thrDateTo;
	 
	 //Session Type
	 
	//Element for Session Type 
		 //@FindBy(id="sessionType")

		   // WebElement thrSessionType;
		 
		 
	//Element for Staff status
		// @FindBy(id="staffStatus")

		   // WebElement thrStaffStatus;
		 
		 
	//Element for Submit button
		 @FindBy(id="submit")

		    WebElement btnSubmit;
		 
	//Element for Create session
		 @FindBy(xpath="//button[(contains(text(),'Create Session'))]")
		 
		 	WebElement btnCreateSession;
		 
	//validaton Element for Date from
		 @FindBy(xpath="//label[(contains(text(),'Date From'))]//following-sibling::div[@class='inputElement']//span[@class='errorMsg']")
		 
		 WebElement valDateFrom;
		 
	//validation Element for Date to
		 @FindBy(xpath="//label[(contains(text(),'Date To'))]//following-sibling::div[@class='inputElement']//span[@class='errorMsg']")
		 
		 WebElement valDateTo;
		 
	//validation Element for No Session Found
		 @FindBy(xpath="//div[@class='detailsBlock SearchResult']/div[normalize-space(text()) = 'No Session Found']")
		 
		 WebElement valNoSessonFound;
		 
		 
		 public SearchSession(WebDriver driver){

		        this.driver = driver;

		        //This initElements method will create all WebElements

		        PageFactory.initElements(driver, this);

		    }
		 
	//Method for Location
		 
		 public void setLocation(String strLocation){

		    	Select thrLocation = new Select(driver.findElement(By.id("location")));
		    	thrLocation.selectByValue(strLocation);

		    }
				 
	//Method for Theatre Name	 
		 public void setTheatreName(String strTheatreName){

		    	Select thrTheatreName = new Select(driver.findElement(By.id("theatreName")));
		    	thrTheatreName.selectByValue(strTheatreName);

		    }
		 
	//Method for Date from
		 public void setDateFrom(String strDateFrom) {
			 thrDateFrom.clear();
			 thrDateFrom.sendKeys(strDateFrom);
		 }
		 
	//Method for Date to
		 public void setDateTo(String strDateTo) {
			 thrDateTo.clear();
			 thrDateTo.sendKeys(strDateTo);
		 }
		 
	//Method for Session Type
		 public void setSessionType(String strSessionType) {
			 Select thrSessionType = new Select(driver.findElement(By.id("sessionType")));
			 thrSessionType.selectByValue((strSessionType));
		 }
		 
	//Method for Session Type
		 public void setStaffStatus(String strStaffStatus) {
			 Select thrStaffStatus = new Select(driver.findElement(By.id("staffStatus")));
			 thrStaffStatus.selectByValue((strStaffStatus));
		 }
		 
	//Method for Search Button
		 public void clickSearch() {
			 btnSubmit.click();
			 
		 }
		 
	//Method for Date From validation
		 public void valDateFrom(String strDateFrom) {
			 String strDate= valDateFrom.getText();
			 Assert.assertEquals(strDateFrom, strDate);
		 
		 }
		 
	//Method for Date to validation
		 public void valDateTo(String strDateTo) {
			 String strTo=valDateTo.getText();
			 Assert.assertEquals(strDateTo, strTo);
		 }
		 
	//Method for No Session found
		 public void valNoSessonFound(String strNoSessionFound) {
			 String strNoSession=valNoSessonFound.getText();
			 Assert.assertEquals(strNoSessionFound, strNoSession);
		 }
}