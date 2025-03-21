package test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Utility;
import pompages.RegistrationPage;

public class RegistratinTest extends BaseClass {

	@Test
	public void testRegistratinTest() throws InterruptedException 
	{
		Reporter.log("RegistratinTest",true);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        String name= Utility.getProperty("src\\main\\resources\\login.csv", "firstname");
        registrationPage.setUserName("Tia");
        registrationPage.setEmail("Ta.pc@gmail.com");
        registrationPage.setPassword("test123");
        registrationPage.setMobile("0041181956");
        registrationPage.handleRecaptcha(driver);
        Thread.sleep(20000);
        registrationPage.setAccept();
        registrationPage.clickSignupButton();
       
	}

}
