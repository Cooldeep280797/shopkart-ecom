package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilsLayer.WaitUtil_Class;

public class Homepage extends WaitUtil_Class {

	public Homepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='shop-now-btn']")
	WebElement shopnowbutton;

	@FindBy(xpath = "//a[contains(@class,'active')]")
	WebElement electronicsTab;

	public void clickShopNowButton() {
		visibilityof(shopnowbutton);
		shopnowbutton.click();
	}

	public boolean isElectronicsPageOpened() {
		return electronicsTab.isDisplayed();
	}

	@FindBy(xpath = "//h1[text()='Big Summer Sale 2024!']")
	WebElement messageSale;

	public String saleMessageValidation() {
		return messageSale.getText();
	}

	@FindBy(xpath = "//p[text()='Up to 60% off on selected items • Free shipping on orders over $50']")
	WebElement discountMessage;

	public String discountMessage() {
		return discountMessage.getText();
	}

	@FindBy(xpath = "//h2[text()='Shop by Category']")
	WebElement sectionTitleXpath;
	
	public void scrollToTitle() {
		scrollWindow(sectionTitleXpath);
	}
	
	public String validateSectionTitle() {
		return sectionTitleXpath.getText();
	}
	
	@FindBy(xpath="//h3[text()='All Products']")
	public WebElement allProductTabValidation;
	
	@FindBy(xpath="//div[contains(@class,'active')]")
	public WebElement allProductTabClickedPath;
	
	public void clickAllProductTab() {
		scrollWindow(allProductTabValidation);
		allProductTabValidation.click();
	}
	
	public boolean isAllProductTabClickable() {
		return allProductTabClickedPath.isDisplayed();
	}
	
	@FindBy(xpath="//h3[text()='Electronics']")
	public WebElement electronicTabValidation;
	
	@FindBy(xpath="//div[contains(@class,'active')]")
	public WebElement electronicTabClickedPath;
	
	public void clickElectronicTab() {
		electronicTabValidation.click();
	}
	
	public boolean isElectronicTabClickable() {
		return electronicTabClickedPath.isDisplayed();
	}
	
	@FindBy(xpath="//h3[text()='Fashion']")
	public WebElement fashionTabClick;
	
	@FindBy(xpath="//div[contains(@class,'active')]")
	public WebElement fashionTabClickedPath;
	
	public void clickFashionTab() {
		fashionTabClick.click();
	}
	
	public boolean isFashionTabClickable() {
		return fashionTabClickedPath.isDisplayed();
	}
	
	@FindBy(xpath="//h3[text()='Home & Garden']")
	public WebElement homeAndGardenTab;
	
	@FindBy(xpath="//div[contains(@class,'active')]")
	public WebElement homeAndGardenTabClicked;
	
	public void clickHomeandGardenTab() {
		homeAndGardenTab.click();
	}
	
	public boolean homeAndGardenTabClickable() {
		return homeAndGardenTabClicked.isDisplayed();
	}
	
	@FindBy(xpath="//h3[text()='Home & Garden']")
	public WebElement sportsTabXpath;
	
	@FindBy(xpath="//div[contains(@class,'active')]")
	public WebElement sportsTabClicked;
	
	public void clickSportsTab() {
		sportsTabXpath.click();
	}
	
	public boolean isSportsTabClickable() {
		return sportsTabClicked.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}