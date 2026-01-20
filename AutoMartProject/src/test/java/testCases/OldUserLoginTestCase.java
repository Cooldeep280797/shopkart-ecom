package testCases;

import org.testng.annotations.Test;

import baseLayer.Testbase_Class;
import pageLayer.LoginPage;

public class OldUserLoginTestCase extends Testbase_Class{
	

	@Test()
	public void chromeSetup() {
		setup("chrome");
	}
	
	
	@Test()
	public void login() {
		P = new LoginPage(driver);
		P.HomepageloginButtonclick();
		P.inputEmailId("k@gmail.com");
		P.LoginButtonClick();
	}	
}