package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;

import pompages.RegistrationPage;
import pompages.AgentPage;
import pompages.CSVUploadPage;
import pompages.DashboardPage;
import pompages.LoginPage;


public class FullSetupTest extends BaseClass {

	@Test

	public void testFullSetupTest() throws InterruptedException  
	{
		Reporter.log("FullSetupTest",true);

		LoginPage loginPage=new LoginPage(driver);
		String Email="pcj@gmail.com";
		String Password="test468";
		loginPage.login(Email,Password);


		//		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		//		Assert.assertTrue(result);

		DashboardPage dashboardPage=new DashboardPage(driver);
		boolean resultd = dashboardPage.verifyDashBoardPageIsDisplayed(wait);
		Assert.assertTrue(resultd);
		//		dashboardPage.hoverOverTeams();
		//		dashboardPage.clickAgent();


		//		AgentPage agentPage=new AgentPage(driver);
		//
		//		String c="h";
		//        String agentName = "Johnbb"+c;
		//        String mobile = "987654340"+c;
		//        String email = c+"joh@gmail.com";
		//        String password = "Tet@123"+c;
		//        agentPage.addAgent(agentName, mobile, email, password);
		//        agentPage.clickConformButton();
		//	    Assert.assertTrue(agentPage.verifyAgentAdded(agentName, email),"Agent was not added successfully.");
		//		Thread.sleep(100000);
		dashboardPage.hoverOverCallList();
		dashboardPage.clickPowerImport();

		CSVUploadPage csvPage=new CSVUploadPage(driver);
		String enterListName="toll";
		String filePathName="C:\\Users\\jishnaabhilash\\Downloads\\Sample File cCopy.csv";
		csvPage.addDetails(enterListName, filePathName);
		csvPage.firstDropdownClickAndSelectFN();
		csvPage.secondDropdownClickAndSelectPhone();
		csvPage.thirdDropdownClickAndSelectNotes();
		csvPage.importDataClick();



	}
}