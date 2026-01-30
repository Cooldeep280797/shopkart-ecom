package pageLayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitClass;

public class HomePage extends WaitClass {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//a[contains(@class,'tab-link')]")
	private List<WebElement> tab;
	
	@FindBy(xpath="//div[contains(@class,'product')]")
	private List<WebElement> products;
	
	
	@FindBy(xpath="//a[text()='Mobiles']")//
	private WebElement mobileTabsPath;
	
	@FindBy(xpath="//a[text()='Electronics']")//
	private WebElement electronicsTabsPath;
	
	@FindBy(xpath="//a[text()='Fashion']")//
	private WebElement fashionTabsPath;
	
	@FindBy(xpath="//a[text()='Home']")//
	private WebElement homeTabsPath;
	
	@FindBy(xpath="//div[@class='logo']")
	private WebElement shopKartLogoPath;
	
	@FindBy(xpath="//span[contains(@id,'cart-count')]")//
	private WebElement cartCountPath;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchOptionPath;
	
	@FindBy(xpath="//h4[text()='iPhone 14']")
	private WebElement productNameOnSearch;
	
	@FindBy(xpath="//button[@onclick='openCart()']")
	private WebElement isCartButtonDisplayed;
	
	
	public boolean isShopKartDisplayed() {
		waitForVisibility(shopKartLogoPath);
		return shopKartLogoPath.isDisplayed();
	}
	
	public void searchTabValidation(String ProductName) {
		waitForVisibility(searchOptionPath);
		searchOptionPath.sendKeys(ProductName);
	}
	
	public boolean isProductDisplayedOnSearch() {
		waitForVisibility(productNameOnSearch);
		return productNameOnSearch.isDisplayed();
	}
	
	public boolean isCartButtonDisplayed() {
		waitForVisibility(isCartButtonDisplayed);
		return isCartButtonDisplayed.isDisplayed();
	}
	
	public boolean clickMobileTab() {
		waitForVisibility(mobileTabsPath);
		mobileTabsPath.click();
		WebElement isDisplayedMobile = driver.findElement(By.xpath("//a[contains(@class,'active')]"));
		return isDisplayedMobile.isEnabled();
	}
	
	public boolean clickElectronicsTab() {
		waitForVisibility(electronicsTabsPath);
		electronicsTabsPath.click();
		WebElement isDisplayedElectronics = driver.findElement(By.xpath("//a[contains(@class,'active')]"));
		return isDisplayedElectronics.isEnabled();
	}
	
	public boolean clickFashionTab() {
		waitForVisibility(fashionTabsPath);
		fashionTabsPath.click();
		WebElement isDisplayedFashion = driver.findElement(By.xpath("//a[contains(@class,'active')]"));
		return isDisplayedFashion.isEnabled();
	}
	
	public boolean clickHomeTab() {
		waitForVisibility(homeTabsPath);
		homeTabsPath.click();
		WebElement isDisplayedHome = driver.findElement(By.xpath("//a[contains(@class,'active')]"));
		return isDisplayedHome.isEnabled();
	}
	
	public void clickTab(String tabName) {
		for(WebElement tabs:tab) {
			if(tabs.getText().equalsIgnoreCase(tabName)) {
				waitForVisibility(tabs);
				tabs.click();
				break;
			}
		}
	}
	
	public int cartCount() {
		return Integer.parseInt(cartCountPath.getText());
	}
	
	public boolean validateProductIsDisplayed() {
		if (products.isEmpty()) {
			System.out.println("No products found");
			return false;
		}
		
		waitforListElement(products);
		products.forEach(p -> System.out.println(p.getText()));
		return true;
	}
}