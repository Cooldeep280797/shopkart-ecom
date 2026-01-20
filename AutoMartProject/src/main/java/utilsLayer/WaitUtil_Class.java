package utilsLayer;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil_Class {

	protected WebDriverWait w;
	JavascriptExecutor je;

	public WaitUtil_Class(WebDriver driver) {

		w = new WebDriverWait(driver, Duration.ofSeconds(5));
		je = ((JavascriptExecutor)driver);
		
	}

	public void visibilityof(WebElement emailId) {
		w.until(ExpectedConditions.visibilityOf(emailId));
	}
	
	public void scrollWindow(WebElement scrollElement) {
		je.executeScript("arguments[0].scrollIntoView(true)",scrollElement);
	}
}