package dxc.lca.automation.common;

import org.testng.*;


public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure_"+ result.getTestClass().getClass().getSimpleName() + "_" + result.getName());
    }
}
