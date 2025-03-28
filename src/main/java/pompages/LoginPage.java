package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pompages.DashboardPage;
import org.testng.Assert;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(id="txtEmailId")
	private WebElement emailTB;

	@FindBy(id="txtPassword")
	private WebElement pwTB;
	
	@FindBy(id="btnLogIn")
	private WebElement loginBTN;
	
	@FindBy(xpath="//div[contains(@class,'sweet-alert') and contains(@class,'visible')]")
	private WebElement errMsg;
	
    // Login Eror
	public boolean verifyErrMsgIsDisplayed(WebDriverWait wait )
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			System.out.println("Err Msg is displayed");
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Err Msg is Not displayed");
     		return false;
		}
	}
	// login with email.password
	public void login(String email, String password) {

        emailTB.sendKeys(email);
        pwTB.sendKeys(password);
        loginBTN.click();
	}

}
