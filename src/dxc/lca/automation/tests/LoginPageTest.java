package dxc.lca.automation.tests;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dxc.lca.app.pages.LoginPage;
import dxc.lca.app.pages.StartPage;
import dxc.lca.automation.common.Constants;
import dxc.lca.automation.common.utils.IWaitCondition;
import dxc.lca.automation.common.utils.WaitUtils;

/**
 * The object class will be used as a property of the  Base Page class
 * @author Thien Tran
 */

public class LoginPageTest extends BaseTest{

	public String originalWindow;
	
	@BeforeClass
	protected void beforeClass() {
		originalWindow = new ArrayList<String>(driver.getWindowHandles()).get(0);
	}

	@Test
	public void loginSuccessTest() throws Exception	//throws InterruptedException
	{
		// Step.1 Start page is display. Select button Login
		System.out.println("Step.1 Start page is display. Select button Login");
		final int waitTimeInSeconds = 30;
		StartPage page = new StartPage(this.driver);
		boolean isRender = page.waitUntilRender(waitTimeInSeconds);
		assertTrue(isRender,"The start page is not rendered");
		this.takeScreenShot("StartPage");
		// wait for button enable
		TimeUnit.MILLISECONDS.sleep(500);
		page.getLoginButton().click();

//		 Step.2 Verified that login pag()driver.getWindowHandle();
		int waitingTimeInMiliseconds = waitTimeInSeconds*1000; // MILLISECONDS
		int i = 0;
		while (driver.getWindowHandles().size() < 2 && i < waitingTimeInMiliseconds) {
			i+=500;
			TimeUnit.MILLISECONDS.sleep(500);
		}
		
		List<String> winList = new ArrayList<String>(driver.getWindowHandles());
		String secondWin = null;
		if (driver.getWindowHandles().size() == 2) 
		{
			winList.remove(originalWindow);
			secondWin = winList.get(0);
			driver.switchTo().window(secondWin);
		}
		assertNotNull(secondWin,"Login page is not displayed");

		//
		// Step.3 Fill in user name and password. Click button login. Verified that Login page is closed
		System.out.println("Step.3 Fill in user name and password. Click button login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(Constants.OpenID_Username);
		loginPage.enterPassword(Constants.OpenID_Password);
		this.takeScreenShot("LoginPage");
		loginPage.getLoginButton().click();

		IWaitCondition waitCondition = new IWaitCondition() {
			@Override
			public boolean matchCondition() {
				return driver.getWindowHandles().size() == 1;
			}
		};
//		IWaitCondition waitCondition = () -> {
//			return driver.getWindowHandles().size() == 1;
//		};
		boolean isCloseLoginPage = WaitUtils.waitFor(waitCondition, waitingTimeInMiliseconds);
		assertTrue(isCloseLoginPage, "The Login page is not closed");
		driver.switchTo().window(originalWindow);
		System.out.println("Loggined to LCA succesfully.");
		
		TimeUnit.MILLISECONDS.sleep(2000);
		this.takeScreenShot("Today visit");

		//assertTrue(false, "The Login page is not close");

	}

}
