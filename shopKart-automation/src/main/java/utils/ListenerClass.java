package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;

public class ListenerClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		Object testclass = result.getInstance();
		WebDriver driver = ((TestBase)testclass).getDriver();
		ScreenshotUtilClass.takeScreenshot(driver, result.getName());
	}
}