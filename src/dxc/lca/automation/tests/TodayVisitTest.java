package dxc.lca.automation.tests;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;

import dxc.lca.app.pages.Todayvisit;
//import dxc.lca.app.pages.TodayVisitPage;
import dxc.lca.automation.common.*;

public class TodayVisitTest  extends BaseTest {
	
	@Test
	public void Todayvisit() throws Exception	{
		//Check if Today's Visit page is displayed
		Todayvisit pageTodayVisit = new Todayvisit(driver);

		//String txtPageTitle;
		if (pageTodayVisit.comparePageTitle("Today's Visits") == true)
		{
			System.out.println("Today's Visits page is displayed");
		}
		else
		{
			System.out.println("Today's Visits page is NOT displayed");
		}
		System.out.println("Current application mode :" + pageTodayVisit.getCurrentAppMode());
		this.takeScreenShot("Today Visit Displayed");
		// **Select a patient 
		pageTodayVisit.lefPane.selectElementByPASID(Constants.PatientID_01);
		System.out.println("Selected contact of the patient :" + Constants.PatientID_01);
		TimeUnit.MILLISECONDS.sleep(3000);
		this.takeScreenShot("SelectContact");		
	}
}
