package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pageLayer.HomePage;
import testData.TestDataUtils;

public class TestCase_homePageValidation extends TestBase {

	@DataProvider(name = "getData")
	public Object[][] getData() throws Exception {
		return TestDataUtils.getUtilsClass("TestData/testdata.xlsx", "productName");
	}

	@Test(priority=0,dataProvider = "getData")
	public void TC01_shopKartLogoValidation(String ProductName) {
		hp = new HomePage(driver);

		Assert.assertTrue(hp.isShopKartDisplayed(), "Shopkart logo is not displayed");

		hp.searchTabValidation(ProductName);
		Assert.assertTrue(hp.isProductDisplayedOnSearch(), "Product is not displayed");

		Assert.assertTrue(hp.isCartButtonDisplayed(), "Cart button is not displayed");

	}
	
	@Test(priority=1)
	public void validateProduct() {
		String[] product = { "Mobiles", "Electronics", "Fashion", "Home" };

		for (String tab : product) {
			System.out.println("validating tab" + tab);
			hp.clickTab(tab);
			Assert.assertTrue(hp.validateProductIsDisplayed(), "product not dislayed");
		}
	}
}