package dxc.lca.automation.tests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import dxc.lca.automation.common.Constants;
import dxc.lca.automation.common.EnvironmentManager;
import dxc.lca.automation.common.utils.FileUtils;

/**
 * The base class test the sub text class will inherit
 * @author ttran223
 *
 */
public abstract class BaseTest_OLD {

	protected WebDriver driver;

	public String getPageTestName() {
		Class<?> enclosingClass = getClass().getEnclosingClass();
		if (enclosingClass != null) {
			return enclosingClass.getSimpleName();
		}
		return getClass().getSimpleName();
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = EnvironmentManager.getWebDriver();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			String fileName = "/Fail_" + this.getPageTestName() + "_" + result.getName() + ".png";
			this.takeScreenShot(fileName, true);
		}
	}
	
	/**
	 * Note keep this method protected.
	 * @param Description
	 */
	protected void takeScreenShot(String Description) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement element = stackTraceElements[2];
		String fileName = String.format("%s_%s_%s.png", this.getPageTestName(),element.getMethodName(), Description);
		this.takeScreenShot(fileName, false);
	}
	
	private void takeScreenShot(String outFilename, boolean toReport) {
		try {
			// Create refernce of TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;

			// Call method to capture screenshot
			File source = (File) ts.getScreenshotAs(OutputType.FILE);

			String fileName = Constants.PATH_SREENSHOT+"/" +outFilename;
			FileUtils.copyFile(source,
					new File(fileName));
			if (toReport) {
	            Reporter.log("<br/><a href='"+ fileName + "' height='100' width='100'/> </a><br/>");
			}
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
}
