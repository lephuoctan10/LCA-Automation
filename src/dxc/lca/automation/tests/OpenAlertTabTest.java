package dxc.lca.automation.tests;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import dxc.lca.app.pages.Todayvisit2;

//import org.openqa.selenium.WebDriver;

//import dxc.lca.app.pages.Todayvisit2;
//import dxc.lca.app.pages.TodayVisitPage;
//import dxc.lca.automation.common.*;

public class OpenAlertTabTest  extends BaseTest {
	
	@Test
	public void AlertTab() throws Exception	{
		Todayvisit2 pageAlertTab = new Todayvisit2(driver);
		
		// * Click Arrive Button
//		pageAlertTab.getcArrivedbtn();
//     	System.out.println("Selected Visit Tab");
//    	this.takeScreenShot("Arrived_contact");
//    	TimeUnit.MILLISECONDS.sleep(2000);
//    	 * Select Alert Tab 
		pageAlertTab.getalerttab();
     	System.out.println("Selected Alert Tab");
     	TimeUnit.MILLISECONDS.sleep(2000);
	    this.takeScreenShot("Selected_AlertTab");
	   
	 // * Open Create Alert Form
//	    pageAlert.getAlertbtn();
//     	System.out.println("Open Create Alert Form");
//     	TimeUnit.MILLISECONDS.sleep(3000);
//    	this.takeScreenShot("Open_Alert_Form");	
    	
	}

	
	
}
