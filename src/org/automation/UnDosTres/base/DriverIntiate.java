package org.automation.UnDosTres.base;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverIntiate {
	public static WebDriver driver;

	@BeforeTest
	public static void launch() throws InterruptedException

	{
		ResourceBundle repository = ResourceBundle.getBundle("object_repository_UnDosTres");

		String browser = repository.getString("browser");

		// To Start Firefox Browser
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			System.setProperty("webdriver.gecko.driver", "/Users/a13400581/Downloads/geckodriver");
			driver = new FirefoxDriver();
			driver.get("https://prueba.undostres.com.mx/");
			driver.manage().window().maximize();

		}
		// To Start Chrome Browser
		else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			System.out.println("Executing on CHROME");
			System.setProperty("webdriver.chrome.driver", "/Users/a13400581/Downloads/chromedriver 2");
			driver = new ChromeDriver();
			driver.get("https://prueba.undostres.com.mx/");
			driver.manage().window().maximize();
		}

		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}

	}

	@AfterTest
	public void close() {
		driver.close();
	}
}