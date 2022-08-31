package org.automation.UnDosTres.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ReusableMethods {

	public WebDriver driver;

	//For click Element
	public void clickElement(WebDriver driver, WebElement element) {
		try {
			// waitForElementClickable(driver, element);
			element.click();
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());

		}

	}

	//For Double Click
	public void doubleClickElement(WebDriver driver, WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.doubleClick(element).perform();
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());

		}
	}

	//Wait for Element to Clickable
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());

		}
	}

	//To Enter text in field
	public void enterText(WebDriver driver, WebElement element, String text) {
		try {
			waitForElementClickable(driver, element);
			element.sendKeys(text);
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());

		}
	}
	
	//To Clear Text 
	public void clearText(WebDriver driver, WebElement element) {
		try {
			waitForElementClickable(driver, element);
			element.clear();
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());

		}
	}

	//Explicit Wait
	public void explicitWait(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());

		}
	}

	//Implicit Wait
	public void implicitWait(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());

		}
	}
}
