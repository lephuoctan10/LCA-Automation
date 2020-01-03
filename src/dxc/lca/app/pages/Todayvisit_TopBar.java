package dxc.lca.app.pages;
import dxc.lca.automation.common.*;
import dxc.lca.automation.common.utils.ExcelUtils;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The object class will be used as a property of the  Base Page class
 * @author Le Nguyen
 *
 */
public class Todayvisit_TopBar 
{
	private WebElement topbarcontent;
	private WebElement pageTitle;
	private WebElement btnMenu;
	private WebElement btnConnection;
	private WebElement statusmode;
	private ExcelUtils excel;
	
	public Todayvisit_TopBar(){}
	
	public Todayvisit_TopBar(WebElement headerBar) throws Exception
	{
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage_TopBar");
		this.topbarcontent = headerBar;
		String pageTitle_path = excel.getCellData(2,4).trim();
		String iconMenu_path = excel.getCellData(3,4).trim();
		String iconSync_path = excel.getCellData(4,4).trim();
		String statusSync_path = excel.getCellData(5,4).trim();	
		
		this.pageTitle = topbarcontent.findElement(By.cssSelector(pageTitle_path));
		this.btnMenu = topbarcontent.findElement(By.cssSelector(iconMenu_path));
		this.btnConnection = topbarcontent.findElement(By.cssSelector(iconSync_path));
		this.statusmode = topbarcontent.findElement(By.cssSelector(statusSync_path));
	}
	
	public WebElement getMenuButton()
	{
		return this.btnMenu;
	}
	public WebElement getConnectionButton()
	{
		return this.btnConnection;
	}
	
	public String getPageTitle()
	{
		String title = this.pageTitle.getText().trim();
		return title;
	}
	
	public String getConnectionMode()
	{
		return this.statusmode.getText().trim(); 
	}
}
