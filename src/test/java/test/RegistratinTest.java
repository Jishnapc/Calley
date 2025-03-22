package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Utility;
import pompages.RegistrationPage;
import pompages.RegistrationVerifyPage;

public class RegistratinTest extends BaseClass {
	WebDriverWait wait ;	 
	@Test(priority = 1)
	public void testValidRegistration() throws InterruptedException {
		Reporter.log("Starting Valid Registration Test", true);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		RegistrationPage registrationPage = new RegistrationPage(driver);


		// Valid data
		String userName = "aavarnsimi";
		String email = "aavarnisimibivi@gmail.com";
		String password = "3655123";
		String mobile = "8105368526";

		// Fill form
		registrationPage.fillRegistrationForm(userName, email, password, mobile);

		// CAPTCHA, accept T&C, submit
		registrationPage.handleRecaptcha(driver);
		Thread.sleep(30000); // Temporary wait for CAPTCHA
		registrationPage.setAccept();
		registrationPage.clickSignupButton();

		// Verify successful registration
		RegistrationVerifyPage registrationVerify = new RegistrationVerifyPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//ClickOTP Ok
		registrationVerify.clickOTPOk(wait);
		// Click Verify
		registrationVerify.clickVerify(wait);
		Assert.assertTrue(registrationVerify.verifyCallyImageDisplayed(wait),
				"Registration failed: Cally image/logo not displayed.");
	}

	@Test(priority = 2)
	public void testInvalidRegistration() throws InterruptedException {
		Reporter.log("Starting Invalid Registration Test", true);

		RegistrationPage registrationPage = new RegistrationPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Invalid data
		String userName = "testUser";
		String email = "invalidEmail";   
		String password = "123";        
		String mobile = "abc123";    

		// Fill form
		registrationPage.fillRegistrationForm(userName, email, password, mobile);

		// CAPTCHA, accept T&C, submit
		registrationPage.handleRecaptcha(driver);
		Thread.sleep(20000);
		registrationPage.setAccept();
		registrationPage.clickSignupButton();

		// Verify error message is displayed
		Assert.assertTrue(registrationPage.verifyErrMsgIsDisplayed(wait),
				"Error message not displayed for invalid registration.");
	}

}

