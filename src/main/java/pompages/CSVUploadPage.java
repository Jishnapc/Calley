package pompages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CSVUploadPage {

	WebDriverWait wait;
	public CSVUploadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}


	@FindBy(id="ContentPlaceHolder1_txtlistname")
	private WebElement listNameInput;
	@FindBy(xpath="//button[@class=\"multiselect dropdown-toggle btn btn-default\"]")
	private WebElement sellectDropDown;
	@FindBy(xpath="//label[contains(text(),'Select All')]")
	private WebElement sellectAllCB;
	@FindBy(id="ContentPlaceHolder1_fileUpload")
	private WebElement chooseBtn;
	@FindBy(xpath="//h4[@class=\"page-title\"]")
	private WebElement callText;
	@FindBy(id ="btnUp")
	private WebElement uploadBtn;
	@FindBy(xpath="//button[@class=\"confirm\"]")
	private WebElement confirmBtn;
	@FindBy(id="ddlbelongto_1")
	private WebElement belongDropdwnFirst;
	@FindBy(id="ddlbelongto_2")
	private WebElement belongDropdwn2;
	@FindBy(id="ddlbelongto_3")
	private WebElement belongDropdwn3;
	@FindBy(xpath="//h4[@class=\"page-title\"]")
	private WebElement matchFieldTXT;
	@FindBy(id="ContentPlaceHolder1_btnUpload")
	private WebElement importDataBTN;
	@FindBy(xpath="//button[@class=\"confirm\"]")
	private WebElement okBtn;


	public void addDetails(String listName,String fpath) throws InterruptedException {
		
		listNameInput.sendKeys(listName);
		sellectDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(sellectAllCB)).click();
		wait.until(ExpectedConditions.elementToBeClickable(callText)).click();
		chooseBtn.sendKeys(fpath);
		uploadBtn.click();
		Thread.sleep(1000);
		confirmBtn.click(); 
	}

	public void outsideMatchClick() {

		matchFieldTXT.click();
		System.out.println("clicked");

	}
	public void firstDropdownClickAndSelectFN() throws InterruptedException {
		belongDropdwnFirst.click();
		Thread.sleep(1000);
		Select select = new Select(belongDropdwnFirst);
		select.selectByVisibleText("FirstName");
		outsideMatchClick();
	}
	public void secondDropdownClickAndSelectPhone() throws InterruptedException {
		belongDropdwn2.click();
		Thread.sleep(1000);
		Select select = new Select(belongDropdwn2);
		select.selectByVisibleText("Phone");
		outsideMatchClick();
	}
	public void thirdDropdownClickAndSelectNotes() throws InterruptedException {
		belongDropdwn3.click();
		Thread.sleep(1000);
		Select select = new Select(belongDropdwn3);
		select.selectByVisibleText("Notes");
		outsideMatchClick();
	}

	public void importDataClick() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(importDataBTN)).click();
		wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();
	}
}



