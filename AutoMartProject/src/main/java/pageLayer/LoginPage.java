package pageLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilsLayer.WaitUtil_Class;

public class LoginPage extends WaitUtil_Class {

	public static WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		w = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Login']")
	WebElement HomepageLoginbutton;

	public void HomepageloginButtonclick() {
		visibilityof(HomepageLoginbutton);
		HomepageLoginbutton.click();
	}

	@FindBy(xpath = "//input[@id='loginEmail']")
	WebElement EmailId;

	public void inputEmailId(String Email) {
		visibilityof(EmailId);
		EmailId.sendKeys(Email);
	}

	@FindBy(xpath = "//input[@id='loginPassword']")
	WebElement Pass;

	public void inputPass(String inputPass) {
		visibilityof(Pass);
		Pass.sendKeys(inputPass);
	}

	@FindBy(xpath = "//i[@class='fas fa-sign-in-alt']")
	WebElement loginButton;

	public void LoginButtonClick() {
		visibilityof(loginButton);
		loginButton.click();
	}
}
