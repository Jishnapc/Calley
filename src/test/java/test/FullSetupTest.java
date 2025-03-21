package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Utility;
import pompages.RegistrationPage;
import pompages.AgentPage;
import pompages.CSVUploadPage;
import pompages.DashboardPage;
import pompages.LoginPage;


public class FullSetupTest extends BaseClass {

	@Test
	
	public void testFullSetupTest()  
	{
		Reporter.log("FullSetupTest",true);
		
        LoginPage loginPage=new LoginPage(driver);
 		loginPage.setEmail("pcj@gmail.com");
		loginPage.setPassword("test468");
		loginPage.clickLoginButton();
		
		
		
//		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
//		Assert.assertTrue(result);
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		boolean resultd = dashboardPage.verifyDashBoardPageIsDisplayed(wait);
		Assert.assertTrue(resultd);
		dashboardPage.hoverOverTeams();
		dashboardPage.clickAgent();
		

		AgentPage agentPage=new AgentPage(driver);

		String c="b";
        String agentName = "Johnbb"+c;
        String mobile = "987654340"+c;
        String email = c+"joh@gmail.com";
        String password = "Tet@123"+c;
        agentPage.addAgent(agentName, mobile, email, password);
        agentPage.clickConformButton();
	//  assertTrue(agentPage.verifyAgentAdded(agentName, email),"Agent was not added successfully.");
//		Thread.sleep(100000);
        dashboardPage.hoverOverCallList();
        dashboardPage.clickPowerImport();
		
		CSVUploadPage csvPage=new CSVUploadPage(driver);
		

}
}