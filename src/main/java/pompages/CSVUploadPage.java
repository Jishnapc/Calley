package pompages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CSVUploadPage {
	
	
	public CSVUploadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		

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

	
	public void enterListName(String listName) {
		listNameInput.sendKeys(listName);
	}
	public void selectAgent() {

		sellectDropDown.click();

	}
	public void selectAllClick() {

		sellectAllCB.click();
		
	}
	
	public void outsideClick() {

		callText.click();
		System.out.println("clicked");
		
	}
	
	
	public void chooseFile(String fpath) {

		chooseBtn.sendKeys(fpath);
	}
	public void uploadBtnClick() {

		uploadBtn.click();
		
	}
	
	
	public void confirmBtnClick() {
		confirmBtn.click();
		
	}
}
