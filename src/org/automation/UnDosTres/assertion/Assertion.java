package org.automation.UnDosTres.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assertion {
	
	WebDriver Driver;
	
	//Assertion for Validation Element on Page	
	public static boolean ValidateElementExist(WebDriver driver,String xpath ){
		
		boolean result=false;
		
		try{
			 driver.findElement(By.xpath(xpath));
			result = true;
			System.out.println("pass assertion");

		   }
		catch(Exception e){
			System.out.println("fail assertion");
		}
		
		return 	result;
	}
	
	//Assertion for Validation text on Page
	public  static boolean ValidateTextOnPage (WebDriver driver,String text){
		boolean textresult = false;
	if(driver.getPageSource().contains(text)){
		textresult = true;
		System.out.println("pass 2 assertion");

	}
	return 	textresult;
	}
	

}

