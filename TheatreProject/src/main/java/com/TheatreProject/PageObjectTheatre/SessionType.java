package com.TheatreProject.PageObjectTheatre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SessionType{
	
	WebDriver driver;
		//Element for Add Session Type field
	   @FindBy(xpath="//div[@class='PageHeader']//button[@class='button button-small']")
	    
	    WebElement btnAddSession;
	   
	   //Element for Enter Session Name
	   @FindBy(id="sessionName")
	   WebElement txtSessionName;
	
	//Element to Enter Start Time
	   @FindBy(id="startTime")
	   WebElement txtStartTime;
	   
	//Element to Enter End Time
	   @FindBy(id="endTime")
	   WebElement txtEndTime;
	 
	   //Element for Save button
	   @FindBy(xpath=".//*[@id='root']/div/div[3]/div[2]/div/button[2]")
	   WebElement btnSave;
	   
	   //Delete SessionType element panel
	   @FindBy(xpath=".//div[@class='tableContainer']//tbody//tr//td[contains(text(),'Test Session Type')]//following-sibling::td//div/button[@class='jss7 jss1']")
	   WebElement btnDeletePanel;
	   
	   //Delete SessionType button
	   @FindBy(id="2")
	   WebElement btnDeleteSessionType;
	   
	   //Delete button in dialogue box
	   @FindBy(xpath="//div[@class='jss29 jss55 jss30 jss73 jss75']//button[@class='button button-primary jss107']")
	   WebElement btnDeleteDialogueBox;
	   
	   
	public void clickAddSessionType() 
	{		
		btnAddSession.click();
		
	}
	
	public void txtSessionName(String strSessionName)
	{
		txtSessionName.clear();
		txtSessionName.sendKeys(strSessionName);;
	}
	
	public void txtStartTime(String strStartTime)
	{
		txtStartTime.clear();
		txtStartTime.sendKeys(strStartTime);
	}
	   
	public void txtEndTime(String strEndTime)   
	{
		txtEndTime.clear();
		txtEndTime.sendKeys(strEndTime);
	}
	
	public void clickSave()
	{
		btnSave.click();
	}
	
	public void clickDeletePanel()
	{
		btnDeletePanel.click();
	}
	
	public void clickSessionDelete()
	{
		btnDeleteSessionType.click();
	}
	
	public void clickDeleteSessionTypeDialogueBox()
	{
		btnDeleteDialogueBox.click();
	}
	
	  public SessionType(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
}