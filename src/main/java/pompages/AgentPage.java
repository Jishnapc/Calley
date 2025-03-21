package pompages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgentPage {
	public Actions actions;
	public WebDriverWait wait;
	public AgentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
	
	}
    @FindBy(xpath = "//input[@placeholder='Enter name']")
    private WebElement nameTB;

    @FindBy(xpath = "//input[@placeholder='Enter mobile no.']")
    private WebElement mobileTB;

    @FindBy(xpath = "//input[@placeholder='Enter email']")
    private WebElement emailTB;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    private WebElement passwordTB;

    @FindBy(xpath = "//input[@id=\"ContentPlaceHolder1_btn_submit\"]")
    private WebElement submitButton;
    
    @FindBy(xpath = "//table//tbody/tr[1]/td[1]")  
    private WebElement sNumber;

    @FindBy(xpath = "//table//tbody/tr[1]/td[2]")  
    private WebElement agentID;

    @FindBy(xpath = "//table//tbody/tr[1]/td[3]")  
    private WebElement agentName;

    @FindBy(xpath = "//table//tbody/tr[1]/td[4]")  
    private WebElement agentEmail;
 
    @FindBy(xpath = "//button[@class=\"confirm\"]")  
    private WebElement conformBTN;
    	
    public void addAgent(String name, String mobile, String email, String password) {
        nameTB.sendKeys(name);
        mobileTB.sendKeys(mobile);
        emailTB.sendKeys(email);
        passwordTB.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(conformBTN)).click();
      
    }
	
    public boolean verifyAgentAdded(String expectedName, String expectedEmail) {
        String actualName = agentName.getText();
        String actualEmail = agentEmail.getText();
        String agentId = agentID.getText();  
        String serialNumber = sNumber.getText();  
        if (actualName.equals(expectedName) &&
               actualEmail.equals(expectedEmail) &&
               !agentId.isEmpty() &&
               !serialNumber.isEmpty())
        {
        	return true;
        }
        else 
        	return false;
    }


}




