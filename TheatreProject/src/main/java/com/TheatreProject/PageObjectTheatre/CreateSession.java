package com.TheatreProject.PageObjectTheatre;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateSession{

WebDriver driver;

//Element for Create Session button
@FindBy(xpath="//button[@class='button button-small']")

WebElement btnCreateSession;


//Element for Session type
@FindBy(xpath=".//div[@class='checkboxContainer']//label[(text()=\"Test Session Type (  14:00-16:00 )\")]")
WebElement chkSessionType;


//Element for Save new session
@FindBy(xpath=".//*[@id='root']/div/div[2]/div/div[2]/div[2]/div/button[2]")
WebElement btnSaveSession;

//Element for click Delete Panel
@FindBy(xpath=".//div[@class='tableContainer']//tbody//tr//td[contains(text(),'Test Session Type')]//following-sibling::td//div/button[@class='jss7 jss1']")
WebElement clkDeletePanel;

@FindBy(xpath="//li[@id='2']")
WebElement btnPanelDeleteSession;

//Delete button in dialogue box
@FindBy(xpath="//div//button[contains(text(),'Delete')]")
WebElement btnDeleteDialogueBox;



public String getCurrentDay() {
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	String[] same = (dateFormat.format(date).split("/"));
	String itnumber;
	itnumber=same[0];
	//System.out.println(same[0]);
	//System.out.println(same[1]);
	//System.out.println(same[2]);
	return itnumber;
	
	
}
	
public void selectDate() throws InterruptedException{
	
	//driver.findElement(By.xpath("//button[@class='button button-small']")).click();
	List<WebElement> range = driver.findElements(By.xpath("//div[text()='"+ getCurrentDay() +"']"));
		//System.out.println(range.get(1));
		int getDateSize= range.size();
		
		if (!(getDateSize==2)) {
			
			range.get(0).click();
		}
		
		else {
			
			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			actions.moveToElement(range.get(1)).click().perform();
			
		}
		

}


public void btnCreateSession()
{
	btnCreateSession.click();
}


public void chkSessionType() 
{
	
	chkSessionType.click();
	
}

public void btnSaveSession()
{
	btnSaveSession.click();
}

public void clkDeleteSessionPanel()
{
	clkDeletePanel.click();
	
}

public void btnDeletePanelSession()
{
	btnPanelDeleteSession.click();
}

public void btnDeleteDialogueBox(){
	btnDeleteDialogueBox.click();
}

//Method for Location

/*public void setLocation(String strLocation){

   	Select thrLocation = new Select(driver.findElement(By.id("location")));
   	thrLocation.selectByValue(strLocation);

   }
		 
//Method for Theatre Name	 
public void setTheatreName(String strTheatreName){

   	Select thrTheatreName = new Select(driver.findElement(By.id("theatreName")));
   	thrTheatreName.selectByValue(strTheatreName);

   }*/



	public CreateSession(WebDriver driver){

		this.driver = driver;

    //This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

}

}