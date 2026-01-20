package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilsLayer.WaitUtil_Class;

public class RegisterPage extends WaitUtil_Class {

	public String name;
	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Register']")
	WebElement Registerbutton;

	public void registerButton() {
		visibilityof(Registerbutton);
		Registerbutton.click();
	}
	
	@FindBy(xpath="//input[@id='registerName']")
	WebElement CustomerName;
	
	public void customerName(String name) {
		this.name=name;
		CustomerName.sendKeys(name);
	}
	
	@FindBy(xpath="//input[@id='registerEmail']")
	WebElement CustomerEmail;
	
	public void customerEmail(String Email) {
		visibilityof(CustomerEmail);
		CustomerEmail.sendKeys(Email);
	}
	
	@FindBy(xpath="//input[@id='registerPassword']")
	WebElement Pass;
	
	public void password(String pass) {
		visibilityof(Pass);
		Pass.sendKeys(pass);
	}
	
	@FindBy(xpath="//input[@id='registerConfirmPassword']")
	WebElement ConfirmPass;
	
	public void confirmpassword(String pass) {
		visibilityof(ConfirmPass);
		ConfirmPass.sendKeys(pass);
	}	
	
	@FindBy(xpath="//i[@class='fas fa-user-plus']/parent::button")
	WebElement CreateAccount;
	
	public void createAccount() {
		visibilityof(CreateAccount);
		CreateAccount.click();
	}
	
	@FindBy(xpath="//span[text()='Registration successful!']")
	WebElement toastMessage;
	public void validateToastMessage() {
		System.out.println("ENTER");
		visibilityof(toastMessage);
		System.out.println("Toast Visible");
	}
	
	@FindBy(xpath="//a[@id='loginLink']")
	WebElement AccountValidation;
	
	public void accountValidation() {
		//System.out.println("ValidationENTER");
	String name1 =	AccountValidation.getText();
	System.out.println(name1);
	if(name1.equals(name)) {
		System.out.println("Correct Account");
	}
	else {
		System.out.println("Wrong Account");
	}
	}
}