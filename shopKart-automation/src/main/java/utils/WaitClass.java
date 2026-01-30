package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class WaitClass extends TestBase{

	int timeout = Integer.parseInt(utils.ConfigReader.get("timeout"));
	
	
	public WaitClass(WebDriver driver) {
		this.driver=driver;
		wdw = new WebDriverWait(driver,Duration.ofSeconds(timeout));
	}
	
	public void waitForVisibility(WebElement element) {
		wdw.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitforAlert() {
		wdw.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitforPresenceOfElementLocated() {
		wdw.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Create Account']")));
	}
	
	public void waitforListElement(List<WebElement> element){
		wdw.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Closing Alert" + alert.getText());
		alert.accept();
	}
	
}
