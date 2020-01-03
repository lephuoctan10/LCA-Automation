package dxc.lca.app.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends AbstractComponent {

	public Button(WebDriver webDriver, By rootQuery) {
		super(webDriver, rootQuery);
		// TODO Auto-generated constructor stub
	}

	public boolean waitForEnabled() {
		return true;
	}
	
	private void isEnabled() {
		// TODO Auto-generated method stub
	}
}
