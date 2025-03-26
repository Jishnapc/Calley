package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;

import pompages.RegistrationPage;
import pompages.AgentPage;
import pompages.CSVUploadPage;
import pompages.DashboardPage;
import pompages.LoginPage;


public class FullSetupTest extends BaseClass {
	@DataProvider(name = "loginScenarios")
    public Object[][] getLoginScenarios() {
        return new Object[][] {
            { "jishna.abhilash86@gmail.com", "123456", "valid", "TestLis1", "C:\\Users\\jishnaabhilash\\Downloads\\Sample File cCopy.csv" },
            { "wrong@email.com", "wrongpass", "invalid","",""}
        };
	 }
	
	@Test(dataProvider = "loginScenarios")
	public void testLoginFlow(
	        String email,
	        String password,
	        String loginType,
	        String listName,
	        String filePath
	) throws InterruptedException {
	    Reporter.log("Running Login Scenario: " + loginType, true);

	    // Login
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login(email, password);

	    if (loginType.equalsIgnoreCase("valid")) {
	    	
	        // VALID LOGIN FLOW: Continue with dashboard + agent + CSV
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        boolean isDashboardVisible = dashboardPage.verifyDashBoardPageIsDisplayed(wait);
	        Assert.assertTrue(isDashboardVisible, "Dashboard should be visible after valid login");

	        // Navigate to the agent page.
	        dashboardPage.hoverOverTeams();
	        dashboardPage.clickAgent();

	        AgentPage agentPage = new AgentPage(driver);
	        String agentName = "Jishna";
	        String mobile = "8105368526";
	        String agentEmail ="jisha@gmail.com";
	        String agentPassword = "Test21234";

	        agentPage.addAgent(agentName, mobile, agentEmail, agentPassword);
	        Assert.assertTrue(agentPage.verifyAgentAdded(agentName, agentEmail), "Agent was not added successfully.");

	        // Navigate to Call List > Power Import.
	        dashboardPage.hoverOverCallList();
	        dashboardPage.clickPowerImport();

	        CSVUploadPage csvPage = new CSVUploadPage(driver);
	        csvPage.addDetails(listName, filePath);
	        csvPage.selectFromDropdown("first", "FirstName");
	        csvPage.selectFromDropdown("second", "Phone");
	        csvPage.selectFromDropdown("third", "Notes");
	        csvPage.importDataClick();

	    } else {
	        // INVALID LOGIN FLOW: Check error message
	        boolean isErrorDisplayed = loginPage.verifyErrMsgIsDisplayed(wait);
	        Assert.assertTrue(isErrorDisplayed, "Error message should be visible for invalid login");
	    }
	}

}