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

	@FindBy(xpath="//span[@id=\"ContentPlaceHolder1_lbl_title\"]")
	private WebElement dashboard;
	
	@FindBy(xpath="//*[@id=\"nav\"]/li[5]/a")
	private WebElement dropDownMenu;

	@FindBy(xpath="//*[@id=\"nav\"]/li[5]/ul/li[2]/a")
	private WebElement agent;
	

	
	@FindBy(xpath = "//span[text()='Call List ']")
    private WebElement callListMenu;

    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li[1]/a/span")
    private WebElement addPowerImport;

   

	public void hoverOverTeams() 
	{

		actions.moveToElement(dropDownMenu).perform();
	}
	public void clickAgent() {
		agent.click();
	}
	
	
	 public void hoverOverCallList()   
		{  
	    	
//	    	WebElement callist = wait.until(ExpectedConditions.visibilityOfElementLocated( callListMenu));
//		 Thread.sleep(20000);
	        actions.moveToElement(callListMenu).perform(); 
//	        wait.until(ExpectedConditions.elementToBeClickable(addPowerImport)).click();
	        
		}
		public void clickPowerImport() {
			addPowerImport.click();
		}
		
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
