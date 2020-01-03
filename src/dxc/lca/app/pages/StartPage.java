package dxc.lca.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The page when starting the LCA app
 * @author ttran223
 *
 */
public class StartPage {
	private WebElement loginButton;
	private WebElement portTalLoginComponent;
	private WebDriver driver;
	private By byQuery = By.tagName("page-login");

	public StartPage(WebDriver webDriver) {
		this.driver = webDriver;
		this.refresh();
	}

	public void refresh() {
		if (!isRendered()) {
			return;
		}
		this.portTalLoginComponent = getRootElement().findElement(By.tagName("dxc-portal-login"));
		this.loginButton = this.portTalLoginComponent.findElement(By.tagName("button")); 
	}

	public WebElement getLoginButton() {
		return this.loginButton;
	}

	public WebElement getRootElement() {
		return this.driver.findElement(this.byQuery);
	}

	public boolean isRendered() {
		try {
			this.getRootElement();
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public boolean waitUntilRender(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(this.byQuery));
		} catch (TimeoutException ex) {
			return false;
		}
		if (element!= null) {
			return true;
		}
		return false;
	}
}
