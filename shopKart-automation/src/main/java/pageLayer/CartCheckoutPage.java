package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitClass;

public class CartCheckoutPage extends WaitClass{

	public CartCheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@onclick='openCart()']")
	private WebElement cartBtnPath;
	
	@FindBy(xpath="//h3[text()='Your Cart']")
	private WebElement yourCartTitlePath;
	
	@FindBy(xpath="//div[contains(@class,'cart-item')]")
	private WebElement productsValidationPath;
	
	@FindBy(xpath="//p[contains(@id,'total')]")
	private WebElement priceValidationPath;
	
	@FindBy(xpath="//*[text()='Checkout']")
	private WebElement checkoutBtnPath;
	
	public boolean clickCartBtn() {
		waitForVisibility(cartBtnPath);
		cartBtnPath.click();
		return yourCartTitlePath.isDisplayed();
	}
	
	public boolean cartTitleValidation() {
		return yourCartTitlePath.isDisplayed();
	}
	
	public boolean productNameValidation() {
		return productsValidationPath.isDisplayed();
	}
	
	
}