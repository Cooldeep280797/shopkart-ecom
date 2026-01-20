package testCases;

import org.testng.annotations.Test;

import baseLayer.Testbase_Class;
import pageLayer.RegisterPage;

public class NewUserRegistrationTestCase extends Testbase_Class{

	@Test(priority=0)
	public void chromeSetup() {
		setup("chrome");
	}
	
	@Test(priority=1)
	public void customerRegistration() {
		rp = new RegisterPage(driver);
		rp.registerButton();
		rp.customerName("Anvi");
		rp.customerEmail("anvi@gmail.com");
		rp.password("12345678");
		rp.confirmpassword("12345678");
		rp.createAccount();
		rp.validateToastMessage();
		rp.accountValidation();
	}
	
	@Test(priority=2)
	public void chrometearDown() {
		tearDown();
	}
}
