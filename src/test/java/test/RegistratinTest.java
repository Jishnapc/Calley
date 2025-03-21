package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Utility;
import pompages.RegistrationPage;
import pompages.RegistrationVerifyPage;

public class RegistratinTest extends BaseClass {

	@Test
	public void testRegistratinTest() throws InterruptedException 
	{
		Reporter.log("RegistratinTest",true);
        RegistrationPage registrationPage=new RegistrationPage(driver);

        registrationPage.setUserName("Tiadu");
        registrationPage.setEmail("Taerdu@gmail.com");
        registrationPage.setPassword("test123");
        registrationPage.setMobile("0041181956");
        registrationPage.handleRecaptcha(driver);
        Thread.sleep(20000);
        registrationPage.setAccept();
        registrationPage.clickSignupButton(); 
        
       Assert.assertTrue(registrationPage.verifyErrMsgIsDisplayed(wait)," Registration is not successful");
        
        RegistrationVerifyPage registrationVerify=new RegistrationVerifyPage();
        Assert.assertTrue(registrationVerify.verifyCallyImageDisplayed(wait)," Registration is not successful");
       
	}

}
