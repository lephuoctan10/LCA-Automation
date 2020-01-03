package dxc.lca.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtils;

import dxc.lca.automation.common.Constants;
import dxc.lca.automation.common.utils.ExcelUtils;

/**
 * The base page object class will be inherited by all other object page classes.
 * @author lnguyen52
 *
 */
public class Todayvisit 
{
	public WebDriver driver;
	public WebElement content;
	public Todayvisit_TopBar topBar;
	public Todayvisit_LeftPane lefPane;
//	public Todayvisit_RightPane rightPane_PatientDetail;
		
	private ExcelUtils excel;

	
	public Todayvisit() {}
	
	public Todayvisit(WebDriver driver) throws Exception
	{		
		this.driver = driver;
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage");	
		String pageContent_path = excel.getCellData(1,4).trim();		
		this.content = driver.findElement(By.xpath(pageContent_path));
		initialTopBar();
		initialLeftPane();
//		initialRightPane();
	}
	
	private void initialTopBar() throws Exception {
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage");		
		String pageTopBar_path = excel.getCellData(2,4).trim();
		WebElement _topBar = content.findElement(By.cssSelector(pageTopBar_path));
		this.topBar = new Todayvisit_TopBar(_topBar);
	}
	private void initialLeftPane() throws Exception {
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage");	
		String pageLeftPane_path = excel.getCellData(3,4).trim();
		WebElement _leftPane = content.findElement(By.cssSelector(pageLeftPane_path));
		this.lefPane = new Todayvisit_LeftPane(_leftPane); 
	}
//	private void initialRightPane() throws Exception {
//		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage");	
//		String pageRightPane_path = excel.getCellData(4,4).trim();
//		WebElement _rightPane = content.findElement(By.cssSelector(pageRightPane_path));
//		this.rightPane_PatientDetail = new Todayvisit_RightPane(_rightPane);
//	}
	
	public Boolean comparePageTitle(String txtExpectedPageTitle)
	{
		String title = this.topBar.getPageTitle();
		if (txtExpectedPageTitle.matches(title) == true)
			return true;
		else return false;
	}
	
	public String getCurrentAppMode()
	{
		return this.topBar.getConnectionMode().trim();
	}
	public void openmenu()
	{
		if (topBar.getMenuButton().isEnabled())
		{
			topBar.getMenuButton().click();
		}
	}
	public void switchMode()
	{
		if (topBar.getConnectionButton().isEnabled())
		{
			topBar.getConnectionButton().click();
		}
	}
	public void switchbutton()
	{
		lefPane.getswitchbutton().click();
	}
//	public void getcArrivedbtn()
//	{
//		rightPane_PatientDetail.getArrived().click();
//	}
//	public void getalerttab() {
//		rightPane_PatientDetail.getAlertTab().click();
//	}
//	public void getAlertbtn() {
//		if (rightPane_PatientDetail.getAlert().isEnabled())
//		{
//			rightPane_PatientDetail.getAlert().click();
//		}
//	}
	

}
