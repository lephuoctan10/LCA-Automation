package dxc.lca.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The Log page with user name password and login button
 * @author ttran223
 *
 */
public class LoginPage 
{
	//private WebDriver driver;
	private WebElement Username;
	private WebElement Password;
	private WebElement Login;

	public LoginPage(WebDriver driver) throws Exception
	{
		//** Step 1: Login to LCA									
		this.Username = driver.findElement(By.id("UserName"));	
		this.Password =  driver.findElement(By.id("Password"));	
		this.Login = driver.findElement(By.cssSelector("input[class='btn-login'][type='submit']"));
	}

	public WebElement getLoginButton()
	{
		return this.Login;
	}
	
	public void enterUsername(String text)
	{
		this.Username.sendKeys(text);
	}
	
	public void enterPassword(String text)
	{
		this.Password.sendKeys(text);
	}
}
