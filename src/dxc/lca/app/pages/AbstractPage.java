package dxc.lca.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dxc.lca.app.pages.components.AbstractComponent;

public class AbstractPage extends AbstractComponent {

	AbstractPage(WebDriver webDriver, By rootQuery) {
		super(webDriver, rootQuery);
		// TODO Auto-generated constructor stub
	}

	AbstractPage(WebDriver webDriver, String queryString) {
		super(webDriver, queryString);
		// TODO Auto-generated constructor stub
	}
}
