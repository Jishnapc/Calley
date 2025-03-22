package pompages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationVerifyPage {
	public RegistrationVerifyPage(WebDriver driver)
	{	
		PageFactory.initElements(driver,this);
	}   
	@FindBy(xpath="//button[@class=\"confirm\"]")
	private WebElement otpOKBtn;
	@FindBy(id="btnSignUp")
	private WebElement verifyBTN;
	@FindBy(xpath="//h2[contains(text(),'Try Calley for Free')]")
	private WebElement imgCally;
	
public boolean verifyCallyImageDisplayed(WebDriverWait wait) {
		try
		{
		wait.until(ExpectedConditions.visibilityOf(imgCally));
		System.out.println("Image Cally is displayed");
		return true;
	}
	catch (Exception e) 
	{
		System.out.println("Image Cally is Not displayed");
		return false;
	}
}

//OTP	
	public void clickVerify(WebDriverWait wait) {
	    wait.until(ExpectedConditions.elementToBeClickable(verifyBTN)).click();
	}

//verify
	public void clickOTPOk(WebDriverWait wait) {
		 wait.until(ExpectedConditions.elementToBeClickable(otpOKBtn)).click();		
	}	
}
