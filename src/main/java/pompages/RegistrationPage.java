package pompages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	public JavascriptExecutor driver;
	
	@FindBy(id="txtName")
	private WebElement unTB;
	@FindBy(id="txtEmail")
	private WebElement emailTB;
	@FindBy(id="txtPassword")
	private WebElement pwTB;
	@FindBy(id="txt_mobile")
	private WebElement mbTB;
	@FindBy(xpath = "//iframe[contains(@title,'reCAPTCHA')]")
	private WebElement recaptchaIframe;
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private WebElement recaptchaCheckbox;
	@FindBy(id="checkbox-signup")
	private WebElement acceptCB;
	@FindBy(id="btnSignUp")
	private WebElement signupBTN;
	@FindBy(xpath = "//h1[contains(text(),'Try Calley for Free')]")
	WebElement heading;
	@FindBy(xpath = "//div[@class=\"sa-icon sa-warning pulseWarning\"]")
	WebElement errMsg;
	@FindBy(xpath = "//button[@class=\"confirm\"]")
	WebElement otpBtn;


	public RegistrationPage(WebDriver driver)
	{
		this.driver = (JavascriptExecutor) driver;
		PageFactory.initElements(driver,this);

	}
//Enter required details (e.g., Name, Email, Phone, Password, 
	public void fillRegistrationForm(String userName, String email, String password, String mobile) {
	    unTB.sendKeys(userName);
	    emailTB.sendKeys(email);
	    pwTB.sendKeys(password);
	    mbTB.sendKeys(mobile);
	}

//Clicking Captcha

	public void handleRecaptcha(WebDriver driver) {
		driver.switchTo().frame(recaptchaIframe);
		recaptchaCheckbox.click();
		driver.switchTo().defaultContent();
	}
//Click Accept
	public void setAccept() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",acceptCB);		
	}
//Click SignUP
	public void clickSignupButton()
	{
		signupBTN.click();
	}

//Verification	
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
	}
