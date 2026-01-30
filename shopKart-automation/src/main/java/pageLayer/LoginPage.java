package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitClass;

public class LoginPage extends WaitClass{

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@id='loginBtn']")
	private WebElement homepageLoginButtonPath;
	
	@FindBy(xpath="//div[text()='ShopKart']")
	private WebElement logoPath;
	
	@FindBy(xpath="//input[@id='loginPhone']")
	private WebElement userNameinputPath;
	
	@FindBy(xpath="//input[@id='loginPass']")
	private WebElement passInputPath;
	
	@FindBy(xpath="//button[@onclick='login()']")
	private WebElement loginButtonpath;
	
	
	public boolean homePageButtonClick() {
		System.out.println("done");
		waitForVisibility(homepageLoginButtonPath);
		//System.out.println("done");
		homepageLoginButtonPath.click();
		
		waitForVisibility(userNameinputPath);
		return userNameinputPath.isDisplayed();
	}
	
	public void inputUsername(String username) {
		waitForVisibility(userNameinputPath);
		userNameinputPath.sendKeys(username);
	}
	
	public void inputPass(String password) {
		waitForVisibility(passInputPath);
		passInputPath.sendKeys(password);
	}
	
	public String getEnteredUsernameValue() {
		return userNameinputPath.getAttribute("value");
	}
	
	public String getEnteredPassValue() {
		return passInputPath.getAttribute("value");
	}

	public boolean clickLoginButton() {
		waitForVisibility(loginButtonpath);
		loginButtonpath.click();
		System.out.println("done");
		return logoPath.isDisplayed();
		
	}
	
	
}