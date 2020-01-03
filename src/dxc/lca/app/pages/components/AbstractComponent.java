package dxc.lca.app.pages.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent {
	protected By rootQuery;
	protected WebDriver _driver;
	public AbstractComponent(WebDriver webDriver, By rootQuery) {
		this._driver = webDriver;
		this.rootQuery = rootQuery;
	}
	public AbstractComponent(WebDriver webDriver, String queryString) {
		this._driver = webDriver;
		// TODO implement something here;
	}
	List<AbstractComponent> defaultChilds;
	List<AbstractComponent> dynamicChilds;
	public boolean isRendered() {
		return false;
	}
	public boolean waitUntilRender() {
		if (isRendered()) {
			return true;
		}
		// TODO implement waiting here;
		return false;
	}
}
