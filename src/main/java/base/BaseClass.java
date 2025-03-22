package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver; 
	public WebDriverWait wait;
	public Actions actions;

	@Parameters({"grid","gridURL","browser","ITO","ETO"})
	@BeforeMethod
	public void preCondition
	(
			@Optional("no") String grid,
			@Optional("https://oauth-jishna.pc-13467:1e28c5da-c51e-44c3-93c4-26c352300941@ondemand.eu-central-1.saucelabs.com:443/wd/hub") String gridURL,	// grid or soaucelab url				
			@Optional("chrome") String browser,   //chrome browser
			@Optional("7") String ITO,
			@Optional("6") String ETO	
			) throws MalformedURLException	
	{

		Reporter.log("Execute in Grid:"+grid,true);
		Reporter.log("Browser is:"+browser,true);


		if(grid.equalsIgnoreCase("yes"))// opening  in grid or sourcelab remote system
		{
			URL url=new URL(gridURL);
			if(browser.equalsIgnoreCase("chrome"))// chrome or not
			{
				ChromeOptions options=new ChromeOptions();

				driver=new RemoteWebDriver(url,options);
			}
			else
			{  
				EdgeOptions options=new EdgeOptions();
				driver=new RemoteWebDriver(url,options);
			}
		}
		else
		{

			switch(browser) {
			case "chrome"  :{
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver=new ChromeDriver(options);
				break;
			}

			case "edge"    :{
				driver=new EdgeDriver();
				break;
			}
			}
		}


		Reporter.log("Set ITO:"+ITO,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ITO)));
		
			String appURL=Utility.getProperty("src\\main\\resources\\resources.properties", "app_url");
			Reporter.log("Enter the URL:"+appURL,true);
			driver.get(appURL);
		
//		String apploginURL=Utility.getProperty("src\\main\\resources\\resources.properties", "applogin_url");
//		Reporter.log("Enter the URL:"+apploginURL,true);
//		driver.get(apploginURL);


		Reporter.log("Maximize the browser",true);
		driver.manage().window().maximize();

		Reporter.log("Set ETO:"+ETO,true);
		wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.valueOf(ETO)));


	}

	@AfterMethod
	public void postCondition(ITestResult result) throws Exception
	{
		
	    Thread.sleep(20000);
		Reporter.log("Close the browser",true);
		driver.quit();
	}
}

