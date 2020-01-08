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
 * @author tle256
 *
 */
public class Todayvisit2 
{
	public WebDriver driver;
	public WebElement content;
//	public WebElement test;
//	public BasePage_TopBar topBar;
//	public BasePage_LeftPane lefPane;
	public Todayvisit_RightPane rightPane_PatientDetail;
		
	private ExcelUtils excel;
//	private WebElement switchMode;	
	
	public Todayvisit2() {}
	
	public Todayvisit2(WebDriver driver) throws Exception
	{		
		this.driver = driver;
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage");	
		String pageContent_path = excel.getCellData(1,4).trim();		
//		String test_path = excel.getCellData(5,4).trim();	
		this.content = driver.findElement(By.xpath(pageContent_path));
//		this.test =driver.findElement(By.cssSelector(test_path));
//		initialTopBar();
//		initialLeftPane();
		initialRightPane();
	}
	
//	private void initialTopBar() throws Exception {
//		excel = new ExcelUtils(Constants.BasePageParams_FilePath,"BasePage");		
//		String pageTopBar_path = excel.getCellData(2,4).trim();
//		WebElement _topBar = content.findElement(By.cssSelector(pageTopBar_path));
//		this.topBar = new BasePage_TopBar(_topBar);
//	}
//	private void initialLeftPane() throws Exception {
//		excel = new ExcelUtils(Constants.BasePageParams_FilePath,"BasePage");	
//		String pageLeftPane_path = excel.getCellData(3,4).trim();
//		WebElement _leftPane = content.findElement(By.cssSelector(pageLeftPane_path));
//		this.lefPane = new BasePage_LeftPane(_leftPane); 
//	}
	private void initialRightPane() throws Exception {
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage");	
		String pageRightPane_path = excel.getCellData(4,4).trim();
		WebElement _rightPane = content.findElement(By.cssSelector(pageRightPane_path));
		this.rightPane_PatientDetail = new Todayvisit_RightPane(_rightPane);
	}
	
//	public void getcArrivedbtn()
//	{
//		rightPane_PatientDetail.getArrived().click();
//	}
	public void getalerttab() {
		rightPane_PatientDetail.getAlertTab().click();
	}
	public void getAlertbtn() {
		if (rightPane_PatientDetail.getAlert().isEnabled())
		{
			rightPane_PatientDetail.getAlert().click();
		}
	}
//	public void getCategorybtn() {
//		rightPane_PatientDetail.getCategory().click();
//	}
}

	

	
	
	
	
	
	
