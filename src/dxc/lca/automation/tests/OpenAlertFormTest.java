package dxc.lca.automation.tests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import dxc.lca.app.pages.Todayvisit2;


public class OpenAlertFormTest  extends BaseTest {
	
	@Test
	public void AlertForm() throws Exception	{
		Todayvisit2 pageAlertForm = new Todayvisit2(driver);
//    	 * Select Alert Tab 
		pageAlertForm.getAlertbtn();
     	System.out.println("Open Alert Form");
     	TimeUnit.MILLISECONDS.sleep(2000);
	    this.takeScreenShot("Selected_AlertForm");
	    TimeUnit.MILLISECONDS.sleep(3000);	
	}
	
}