package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.WaitClass;

public class RegisterPage extends WaitClass {

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		s = new Select(genderSelectionPath);

	}

	@FindBy(xpath = "//button[@id=\"registerBtn\"]")
	private WebElement registerButtonHomepagePath;

	@FindBy(xpath = "//h3[text()='Create Account']")
	private WebElement createAccountPath;

	@FindBy(xpath = "//input[@id='regPhone']")
	private WebElement phoneNumberInputPath;

	@FindBy(xpath = "//input[@id='regEmail']")
	private WebElement emailInputPath;

	@FindBy(xpath = "//input[@id='regPass']")
	private WebElement passwordInputPath;

	@FindBy(xpath = "//select[@id='regGender']")
	public WebElement genderSelectionPath;

	@FindBy(xpath = "//input[@id='regDob']")
	private WebElement dobSelectionPath;

	@FindBy(xpath = "//button[@onclick='register()']")
	private WebElement submitButtonPath;

	public boolean clickRegisterButtonHomepage() {
		waitForVisibility(registerButtonHomepagePath);
		registerButtonHomepagePath.click();
		waitForVisibility(createAccountPath);
		return createAccountPath.isDisplayed();
	}

	public void inputPhoneNumber(String phoneNumber, String email, String password, String gender, String dob) {
		waitforPresenceOfElementLocated();

		phoneNumberInputPath.clear();
		phoneNumberInputPath.sendKeys(phoneNumber);

		emailInputPath.clear();
		emailInputPath.sendKeys(email);

		passwordInputPath.clear();
		passwordInputPath.sendKeys(password);

		s.selectByVisibleText(gender);

		dobSelectionPath.sendKeys(dob);

	}

	public void clickSubmit() {
		submitButtonPath.click();
		waitforAlert();
	}
	/*
	 * public String alertHandling() { return handleAlert(); }
	 */

	public void acceptA() {
		acceptAlert();
	}

}