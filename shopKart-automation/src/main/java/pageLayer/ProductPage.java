package pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.WaitClass;

public class ProductPage extends WaitClass{

	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart(String productName) {
		WebElement	addToCartBtn = driver.findElement(By.xpath("//h4[text()='"+productName+"']/ancestor::div//button"));
		addToCartBtn.click();
	}
}