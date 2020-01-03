package dxc.lca.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dxc.lca.automation.common.Constants;

import dxc.lca.automation.common.*;
import dxc.lca.automation.common.utils.ExcelUtils;

public class Todayvisit_RightPane 
{	
	private WebElement rightpanel;
	private WebElement btnArrived;
	private WebElement tabAlert;
	private WebElement btnAlert;
	private WebElement btnCategory; 
	private ExcelUtils excel;
	public Todayvisit_RightPane() {}	
	
	public Todayvisit_RightPane(WebElement _rightPane) throws Exception
	{
		this.rightpanel = _rightPane;
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage_PatientERP");		
//		String arrived_path = excel.getCellData(13,4).trim();		
		String alertTab_path = excel.getCellData(10,4).trim();	
		String alert_path = excel.getCellData(12,4).trim();
//		String category_path = excel.getCellData(15,4).trim();
//    	this.btnArrived =rightpanel.findElement(By.cssSelector(arrived_path));
		this.tabAlert = rightpanel.findElement(By.id(alertTab_path));
		this.btnAlert = rightpanel.findElement(By.cssSelector(alert_path));
//		this.btnCategory = rightpanel.findElement(By.cssSelector(category_path));
	
}

//	public WebElement getArrived()
//	{
//		return this.btnArrived;
//	}	

	public WebElement getAlertTab() {
		return this.tabAlert;
	}
	public WebElement getAlert() {
		return this.btnAlert;
	}
//	public WebElement getCategory() {
//		return this.btnCategory;
//	}
}
