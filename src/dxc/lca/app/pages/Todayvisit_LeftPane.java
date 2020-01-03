package dxc.lca.app.pages;

import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dxc.lca.automation.common.Constants;
import dxc.lca.automation.common.utils.ExcelUtils;

public class Todayvisit_LeftPane
{
	private WebElement leftpanel;
	private WebElement btnswitchday;
//	private WebElement footer;
//	private WebElement elementList;
	private List<WebElement> elementRows;
	private ExcelUtils excel;
	
	public Todayvisit_LeftPane() {}
	
	public Todayvisit_LeftPane(WebElement leftPane) throws Exception 
	{	
		this.leftpanel = leftPane;
		excel = new ExcelUtils(Constants.TodayvisitParamater_FilePath,"BasePage_LeftPane");	
	//	String footer_path = excel.getCellData(1,4).trim();
		String lefpaneBody_path = excel.getCellData(2,4).trim();
		String elementRow_path = excel.getCellData(3,4).trim();
		String switchday_path = excel.getCellData(4,4).trim();
		//CommonFunctions.waitAllElementPresenceByCSSSelector(driver, elementRow_path);		
		this.leftpanel = leftPane;
		//this.footer = content.findElement(By.cssSelector(footer_path));		
		
		WebElement lefpaneBody = leftpanel.findElement(By.cssSelector(lefpaneBody_path));
		//List<WebElement> _elementRows = lefpaneBody.findElements(By.cssSelector(elementRow_path));
		this.elementRows = lefpaneBody.findElements(By.cssSelector(elementRow_path));
        this.btnswitchday =leftpanel.findElement(By.cssSelector(switchday_path));
	}

	public List<WebElement> getElementLlist()
	{
		return this.elementRows;
	}
	
	private WebElement getElementAtIndex(int index)	{
		
		WebElement element = this.elementRows.get(index);
		assertNotNull(element,"==> FAILED. Cannot find element in the left pane with index as " + index); 
		return element; 
	}
	
	public void selectElementAtIndex(int index) {
		
		if (getElementAtIndex(index) != null)	
			getElementAtIndex(index).click();
		//return this.elementRows.get(index); // [position];
	}
	
	public WebElement getElementByPASID(String PasID) {
		
		WebElement elementRow = null;
	
		for (int i = 0; i < this.elementRows.size(); i++) 
		{				
			elementRow = getElementAtIndex(i);
			String elementContent = elementRow.getText();
			
			if (elementContent.contains(PasID))
			{
				return elementRow;
			}
		}
		assertNotNull(elementRow,"==> FAILED. Cannot find row in the left pane with PAS ID as " + PasID); 
		return elementRow;
	}
	
	public void selectElementByPASID(String PasID)
	{		
		if (getElementByPASID(PasID) != null)
			getElementByPASID(PasID).click();
	}
	public WebElement getswitchbutton()
	{
		return this.btnswitchday;
	}
}
