package testCases;

import org.testng.annotations.Test;

import baseLayer.Testbase_Class;
import pageLayer.LoginPage;

public class ValidationOfNewUserLogin extends Testbase_Class {
	
	@Test(priority=0)
	public void browserSetup() {
		setup("chrome");
	}
	
	@Test(priority=1)
	public void LoginNewUser() {
		P = new LoginPage(driver);
		P.HomepageloginButtonclick();
		P.inputEmailId("anvi@gmail.com");
		P.inputPass("12345678");
		P.LoginButtonClick();
	}
}