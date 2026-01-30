package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pageLayer.LoginPage;
import testData.TestDataUtils;

public class TestCase_LoginPageValidation extends TestBase {

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws Exception {
		return TestDataUtils.getUtilsClass("TestData/testdata.xlsx", "Sheet1");
	}

	@Test(dataProvider = "loginData")
	public void TC01_LoginPage(String username, String password) {
		lp = new LoginPage(driver); // Object creation of LoginPage to call methods in Test Class
		
		boolean resultHomepage = lp.homePageButtonClick(); // Stores the value of home page click login as true or false 
		
		Assert.assertEquals(resultHomepage, true, "Unable to click the loginButton from Homepage"); //Hard assert
		//System.out.println("Entered"); //Debugging purpose
		lp.inputUsername(username);		// Enters Username
		lp.inputPass(password);			// Enters Password
		
		boolean resultLoginButton = lp.clickLoginButton();  //Stores true/false value, returns if the button is clicked or not with boolean
		
		Assert.assertEquals(resultLoginButton, true , "Unable to click the login Button after Username Password");  //Hard assert
	}
}