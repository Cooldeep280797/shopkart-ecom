package testCase;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pageLayer.HomePage;
import pageLayer.LoginPage;
import pageLayer.ProductPage;
import pageLayer.RegisterPage;
import testData.TestDataUtils;

public class TestCase_electronicsProductValidation extends TestBase{

	@Test(priority = 0)
	public void TC01() throws InterruptedException {
		rp = new RegisterPage(driver);
		rp.clickRegisterButtonHomepage();
		
		try {
			rp.inputPhoneNumber("9552565645", "k@gmail.com", "12345678", "Male", "28/07/1997");

		} catch (UnhandledAlertException e) {
			rp.acceptAlert();
		} catch (NoSuchElementException e) {
			System.out.println("Could not find gender");
		} finally {
			System.out.println("Iteration Completed");

		}

		rp.clickSubmit();

		rp.acceptA();
		System.out.println("Accepted");
		Thread.sleep(1000);

	}

	@Test(priority = 1, enabled = true)
	public void TC01_LoginPage() {
		lp = new LoginPage(driver); // Object creation of LoginPage to call methods in Test Class

		boolean resultHomepage = lp.homePageButtonClick(); // Stores the value of home page click login as true or false

		Assert.assertEquals(resultHomepage, true, "Unable to click the loginButton from Homepage"); // Hard assert
		// System.out.println("Entered"); //Debugging purpose
		lp.inputUsername("9552565645"); // Enters Username
		lp.inputPass("12345678"); // Enters Password

		boolean resultLoginButton = lp.clickLoginButton(); // Stores true/false value, returns if the button is clicked
															// or not with boolean

		Assert.assertEquals(resultLoginButton, true, "Unable to click the login Button after Username Password"); // Hard
																													// assert
	}

	@DataProvider(name = "getMobileData")
	public Object[][] getMobileData() throws Exception {
		return TestDataUtils.getUtilsClass("TestData/testdata.xlsx", "Electronics");
	}

	@Test(dependsOnMethods = "TC01_LoginPage", dataProvider = "getMobileData", enabled = true)
	public void addTwoMobilesAndValidateCarts(String product1, String product2) {
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
		lp = new LoginPage(driver);

		hp.clickElectronicsTab();

		pp.addProductToCart(product1);
		pp.addProductToCart(product2);

		int actualCount = hp.cartCount();
		Assert.assertEquals(actualCount, 2, "Cart count Mismatch");
	}
}