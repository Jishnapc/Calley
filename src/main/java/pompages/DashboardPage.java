package pompages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	public Actions actions;
	public WebDriverWait wait;
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath="//img[@src=\"images/mobile-logo.png\"]")
	private WebElement dashboard;
	@FindBy(xpath="//span[text()=\"Team\"]")
	private WebElement dropDownMenu;
	@FindBy(xpath="//*[@id=\"nav\"]/li[5]/ul/li[2]/a")
	private WebElement agent;
	@FindBy(xpath = "//span[text()='Call List ']")
	private WebElement callListMenu;
	@FindBy(xpath = "//span[text()=\"Add - Power Import\"]")
	private WebElement addPowerImport;

//mouse over TeamsTab
	public void hoverOverTeams() 
	{

		actions.moveToElement(dropDownMenu).perform();
	}
//Click agent DropDown
	public void clickAgent() {
		agent.click();
	}

//Mousehover CallList
	public void hoverOverCallList()   
	{  
		actions.moveToElement(callListMenu).perform(); 
	}
//Click AddImpotPowr
	public void clickPowerImport() {
		addPowerImport.click();
	}
//Verification of DashBoard
	public boolean verifyDashBoardPageIsDisplayed(WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(dashboard));
			System.out.println("DashboardPage is displayed");
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("DashboardPage is Not displayed");
			return false;
		}
	}

}
