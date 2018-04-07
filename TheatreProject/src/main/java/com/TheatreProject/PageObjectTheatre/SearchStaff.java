package com.TheatreProject.PageObjectTheatre;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SearchStaff {
	
	 WebDriver driver;

	
	//private static final String strval = null;

	/**

     * All WebElements are identified by @FindBy annotation

     */
    
   

    @FindBy(id="lastName")

    WebElement userLastName;

    

    @FindBy(id="firstName")

    WebElement userFirstName;
    
    //validation message for Mandatory field
    @FindBy(xpath="//div[@class='inputElement']//following-sibling::span[contains(text(),'This field is required')]")
    
    WebElement valMandatoryField;
    
    
    
    @FindBy(xpath="//div[@id='root']//input[@type='checkbox']")
    
    List<WebElement> chkAllCheckBox;
    
   
    
    //Validation message for No record found

    @FindBy(xpath="//div[@class='detailsBlock SearchResult']/div[normalize-space(text()) = 'No Record Found']")
    
    WebElement valNoRecordFound;

    

    @FindBy(id="submit")

    WebElement btnSearch;
    
    
    @FindBy(xpath="//div[@id='root']//button[@class='button button-small']")
    	    
    WebElement btnNewTeam;
    
    
    @FindBy(xpath="//div[@id='root']//h3[(contains(text(),'test'))]//following-sibling::div[@class='buttonBlock']//input[@class='button button-secondary']")
    
    WebElement btnView;
    
    
    @FindBy(xpath="//input[@id='newteam']")
    
    WebElement txtNewTeamName;
    
 
    @FindBy(xpath="html/body/div[3]/div/div/div[2]/div[2]/div/button[2]")
    
    WebElement btnNewTeamSave;
    
    
    @FindBy(xpath="//div[@class='CancelSaveButton']/button[@class='button button-primary']")
    
    WebElement btnSave;
    
    
    @FindBy(xpath="searchStaffRole_lbl")
    
    WebElement valRole;
    
    
     
    
    
    
    
    

    public SearchStaff(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    
    
    public void  setCheckBoxValue(String value ) {
    	
 		
     	WebElement child =  driver.findElement(By.xpath("//div[@class='checkboxContainer']//following-sibling::label[contains(text(),'"+ value +"' )]"));
     	     	 
     	     	
        if ( !child.isSelected() )
       {
     	  child.sendKeys(Keys.SPACE); 
        
     }
     	 
        	 
                 	
        	        }
    	
        
    
    public void valdiateRole(String strvalue) {
    	  String eMessage;
		if (strvalue.equals("null") || strvalue =="") {
            	strvalue="";
      	  eMessage = valRole.getText();
      	  Assert.assertEquals(eMessage,strvalue);
      	  }
      	  else {
      		  eMessage = valRole.getText();
          	  Assert.assertEquals(eMessage,strvalue);
      	  }
    }

    public void clickSave() {
    	btnSave.click();
    }
    
    //Set user Lastname in textbox

    public void setLastName(String strLastName){
    	userLastName.clear();
        userLastName.sendKeys(strLastName);

        }

    public void setNewTeamName(String strTeamName)
    {
    	txtNewTeamName.clear();
    	txtNewTeamName.sendKeys(strTeamName);
    }
    
    public void ClickNewTeamSave()
    {
    	btnNewTeamSave.click();
    }
    
    public void ClickView()
    {
    	btnView.click();
    }
    
    
    public void ClickNewTeam() {
    	
    	btnNewTeam.click();
    }

    //Set user FirstName in textbox

    public void setFirstName(String strFirstName){
    	userFirstName.clear();
    	userFirstName.sendKeys(strFirstName);

    }

    

    //select Role from drop down

    public void setRole(String strRole){

    	Select userRole = new Select(driver.findElement(By.id("role")));
    	userRole.selectByValue(strRole);

    }

    

    //Select Team from drop down

    public void setTeam(String strTeam){
    	
     	Select userTeam = new Select(driver.findElement(By.id("team")));
    	userTeam.selectByValue(strTeam);
     	
    	
    

    }
    
    public void clickSearch() {
    
    	//new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform(); 
     
    	btnSearch.click();
    	
    }
    
    public void validationSearchStaff(String valMsg) {
    	
    	Object eMessage = valMandatoryField.getText();
  	  Assert.assertEquals(eMessage,valMsg);
    	
    }
    
    
    public void validationNoRecordFound(String valNoMsg) {
    	
    	Object eMessage = valNoRecordFound.getText();
    	  Assert.assertEquals(eMessage,valNoMsg);
    	
    }
    
    public void chkCheckAllCheckbox() {
    	
    	
		List<WebElement> children = chkAllCheckBox;
  	  
  	  for (int i = 0; i < children.size(); i++) { 
  		if (children.get(i).isSelected())
  			
  		  children.get(i).sendKeys(Keys.SPACE); 
  		  } 
    	
    }
    
    
    

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void SearchTheatreStaff(String strLastName,String strFirstName,String strRole,String strTeam,String strvalue,String value,String valNoMsg){

        //Fill Last  name

        this.setLastName(strLastName);

        //Fill First name

        this.setFirstName(strFirstName);
        
        //Select Role drop down
        
        this.setRole(strRole);
        
        //Select Team drop down
        
        this.setTeam(strTeam);
        
     
        //Click Search button

        this.clickSearch();
        
        this.chkCheckAllCheckbox();
        
        this.clickSave();
        
        this.validationNoRecordFound(valNoMsg);
		this.valdiateRole(strvalue);
      
		this.setCheckBoxValue(value);
                

    }


		
	}


