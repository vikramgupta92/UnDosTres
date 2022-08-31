package org.automation.UnDosTres.testcases;

import java.util.ResourceBundle;

import org.automation.UnDosTres.assertion.Assertion;
import org.automation.UnDosTres.base.DriverIntiate;
import org.automation.UnDosTres.pages.RechargeFlow;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class TC_001VerifyRechargeFlow extends DriverIntiate {

	ResourceBundle repository = ResourceBundle.getBundle("object_repository_UnDosTres");

	public void test() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();

		RechargeFlow Rechargeflw = new RechargeFlow(driver);
		Rechargeflw.login();

		String rechargetext = repository.getString("recharge_text");
		Assertion.ValidateElementExist(driver, rechargetext);

		Rechargeflw.payment();
		softAssertion.assertAll();

	}
}
