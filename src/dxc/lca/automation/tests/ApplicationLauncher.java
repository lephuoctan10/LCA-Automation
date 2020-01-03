package dxc.lca.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dxc.lca.automation.common.Constants;
import dxc.lca.automation.common.EnvironmentManager;
import dxc.lca.automation.common.utils.FileUtils;

public class ApplicationLauncher {

	ApplicationLauncher() {
		EnvironmentManager.setAppLauncher(this);
	}
	public WebDriver driver;
	@BeforeSuite
	public void launchApp () {
		System.out.println("------------- BeforeSuite ------------");
		System.out.println("launching browser");
		if (driver == null) {
			//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver-v4.2.0-win32-x64\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_win32_2.38\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.logfile", "D:\\chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			ChromeOptions chromeOptions = new ChromeOptions();
			
			chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
//			chromeOptions.addArguments("disable-infobars"); // disabling infobars
//			chromeOptions.addArguments("--disable-extensions"); // disabling extensions
//			chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
//			chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//			chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
//			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--auto-open-devtools-for-tabs"); // open chrome debug mode
			chromeOptions.setBinary("C:\\Program Files\\CommunityAide\\CommunityAide.exe");
//			chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(chromeOptions);
		}
		EnvironmentManager.setWebDriver(driver);
		FileUtils.makeDirectory(Constants.PATH_SREENSHOT);
		System.out.println("----------- Done Before suite ----------");

	}

	@AfterSuite
	public void tearDown() throws Exception 
	{
		//Close all the the browser/popup that Selenium opened
		System.out.println("------------- AfterSuite ------------");
		System.out.println("Closing browser");
		driver.quit();
		System.out.println("---------- Done AfterSuite ---------");
	}
}
