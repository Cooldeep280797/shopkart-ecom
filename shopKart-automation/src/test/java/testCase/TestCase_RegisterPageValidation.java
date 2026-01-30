package testCase;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pageLayer.RegisterPage;
import testData.TestDataUtils;

public class TestCase_RegisterPageValidation extends TestBase {

	@DataProvider(name = "getData")
	public Object[][] getData() throws Exception {
		return TestDataUtils.getUtilsClass("TestData/testdata.xlsx", "Register");
	}

	@Test(dataProvider = "getData")
	public void TC01(String PhoneNumber, String Email, String Password, String Gender, String dob) {
		rp = new RegisterPage(driver);
		rp.clickRegisterButtonHomepage();
		
		try {
			rp.inputPhoneNumber(PhoneNumber, Email, Password, Gender, dob);

		} catch (UnhandledAlertException e) {
			rp.acceptAlert();

		} catch (NoSuchElementException e) {
			System.out.println("Could not find gender");
		}

		finally {
			System.out.println("Iteration Completed");
			driver.navigate().refresh();
		}

	}
}