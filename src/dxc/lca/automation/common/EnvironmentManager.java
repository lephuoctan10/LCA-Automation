package dxc.lca.automation.common;

import org.openqa.selenium.WebDriver;

import dxc.lca.automation.tests.ApplicationLauncher;

public class EnvironmentManager 
{
	private static WebDriver _driver;  
	private static ApplicationLauncher _appLauncher;

	public EnvironmentManager() {}
	
	public static WebDriver getWebDriver() 
	{
		if (_driver == null) {
			System.out.println("Get Web driver when app is not running");
			_appLauncher.launchApp();
		}
		return _driver;
	}
	
	public static void setWebDriver(WebDriver driver) {
		_driver = driver;
	}
	
	public static void setAppLauncher(ApplicationLauncher appLauncher) {
		_appLauncher = appLauncher;
	}
}
