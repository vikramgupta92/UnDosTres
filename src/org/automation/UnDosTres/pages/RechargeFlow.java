package org.automation.UnDosTres.pages;

import java.util.ResourceBundle;

import org.automation.UnDosTres.assertion.Assertion;
import org.automation.UnDosTres.utility.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class RechargeFlow {
	ResourceBundle repository = ResourceBundle.getBundle("object_repository_UnDosTres");

	@FindBy(how = How.XPATH, using = "//input[@type='text'and @name='mobile'and@suggestmobile ='mobile-numbers']")
	WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = "//input[@type='text'and @name='operator' and @data-qa='celular-operator']")
	WebElement operator;

	@FindBy(how = How.XPATH, using = "//*[@data-show='Telcel' and @data-name='telcel']")
	WebElement telenet;

	@FindBy(how = How.XPATH, using = "//*[@data-name='10' and @data-show = '$10 (Recarga Saldo)']")
	WebElement amount;

	@FindBy(how = How.XPATH, using = "//*[@class='button buttonRecharge' and @data-qa='celular-pay']")
	WebElement rechargeButton;

	@FindBy(how = How.XPATH, using = "//*[@data-qa='tarjeta-tab']")
	WebElement paymentOption;

	@FindBy(how = How.XPATH, using = "//*[@class='radio-custom-label' and @for='radio-c']")
	WebElement paymentOptionSelection;

	@FindBy(how = How.XPATH, using = "//*[@id='cardnumberunique']")
	WebElement cardNumber;

	@FindBy(how = How.XPATH, using = "//*[@name='expmonth' and @data-qa='mes-input']")
	WebElement expiryMonth;

	@FindBy(how = How.XPATH, using = "//*[@name='expyear' and @data-qa='expyear-input']")
	WebElement expiryYear;

	@FindBy(how = How.XPATH, using = "//*[@name='cvvno' and @data-qa='cvv-input']")
	WebElement cvv;

	@FindBy(how = How.XPATH, using = "//*[@name='txtEmail' and @class='form-control email preventChromeAutofill']")
	WebElement email;

	@FindBy(how = How.XPATH, using = "//*[@id='paylimit']")
	WebElement pay;

	@FindBy(how = How.XPATH, using = "//*[@name='email' and @id='usrname']")
	WebElement userName;

	@FindBy(how = How.XPATH, using = "//*[@name='password' and @id='psw']")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//*[@class='g-recaptcha' ]/div/div/iframe")
	WebElement capatcha;

	@FindBy(how = How.XPATH, using = "//*[@id='loginBtn']")
	WebElement submit;

	public static WebDriver driver;

	public RechargeFlow(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage());
			Assert.assertTrue(false, e.getStackTrace().toString());
		}

	}

	ReusableMethods reusableMethods = new ReusableMethods();
	Assertion asert = new Assertion();

	public void login() throws InterruptedException {

		String mobileNumb = repository.getString("mobile");

		reusableMethods.explicitWait(driver, mobileNumber);

		reusableMethods.enterText(driver, mobileNumber, mobileNumb);

		reusableMethods.clickElement(driver, operator);

		reusableMethods.clickElement(driver, telenet);

		reusableMethods.clickElement(driver, amount);

		reusableMethods.clickElement(driver, rechargeButton);

		reusableMethods.implicitWait(driver);

	}

	public void payment() throws InterruptedException {

		String Numbercard = repository.getString("cardNumber");
		String monthExpiry = repository.getString("expiryMonth");
		String yearExpiry = repository.getString("expiryYear");
		String cvvNumber = repository.getString("cvv");
		String emailId = repository.getString("email");
		String usersName = repository.getString("userName");
		String pwd = repository.getString("password");

		reusableMethods.clickElement(driver, paymentOption);

		reusableMethods.clickElement(driver, paymentOptionSelection);

		reusableMethods.enterText(driver, cardNumber, Numbercard);

		reusableMethods.enterText(driver, expiryMonth, monthExpiry);

		reusableMethods.enterText(driver, expiryYear, yearExpiry);

		reusableMethods.enterText(driver, cvv, cvvNumber);

		reusableMethods.enterText(driver, email, emailId);

		reusableMethods.clickElement(driver, pay);

		reusableMethods.enterText(driver, userName, usersName);

		reusableMethods.enterText(driver, password, pwd);
		Thread.sleep(5000);
		
		reusableMethods.clickElement(driver, capatcha);

		Thread.sleep(5000);

		reusableMethods.clickElement(driver, submit);

	}

}
