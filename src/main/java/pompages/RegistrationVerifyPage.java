package pompages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationVerifyPage {
	
	@FindBy(xpath="//h2[contains(text(),'Try Calley for Free')]")
	private WebElement imgCally;
	
	
	public boolean verifyCallyImageDisplayed(WebDriverWait wait)
	{
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

}
