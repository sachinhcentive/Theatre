package com.TheatreProject.Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;


public class DatePicker{
	WebDriver driver;
	
@Test
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
@Test	
public void selectDate() throws InterruptedException{
	
	driver.findElement(By.xpath("//button[@class='button button-small']")).click();
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
	}
