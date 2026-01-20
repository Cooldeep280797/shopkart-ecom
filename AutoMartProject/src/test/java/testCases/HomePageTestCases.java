package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLayer.Testbase_Class;
import pageLayer.Homepage;

public class HomePageTestCases extends Testbase_Class {

	
	@BeforeTest()
	public void browserSetup() {
		setup("chrome");
		hp = new Homepage(driver);
	}
	
	@AfterTest()
	public void tearDown() {
		super.tearDown();
	}
	
	@Test(enabled = true)
	public void ShopNowButtonValidation() {
		hp.clickShopNowButton();
		System.out.println("ShopNowButtonValidation - Validation done");
	}

	@Test(enabled = true)
	public void electronicTabValidation() {
		Assert.assertTrue(hp.isElectronicsPageOpened(), "Electronic page was not opened after clicking shop now");
		System.out.println("electronicTabValidation - Validation done");
	}

	@Test(enabled = true)
	public void saleMessageValidation() {
		Assert.assertEquals(hp.saleMessageValidation(), "Big Summer Sale 2024!",
				"Expected text message is not displayed");
		System.out.println("saleMessageValidation - Validation done");
	}

	@Test(enabled = true)
	public void discountMessage() {
		Assert.assertEquals(hp.discountMessage(), "Up to 60% off on selected items • Free shipping on orders over $50",
				"Expected text message is not displayed");
		System.out.println("discountMessage - Validation done");
	}

	@Test(enabled = true)
	public void validateSectionTitle() {
		hp.scrollToTitle();
		Assert.assertEquals(hp.validateSectionTitle(), "Shop by Category", "Expected text message is not displayed");
		System.out.println("SectionTitle - Validation done");
	}
	
	@Test(enabled=true)
	public void allProductClickable() {
		hp.clickAllProductTab();
		Assert.assertEquals(hp.isAllProductTabClickable(),"Product is not clicked");
		System.out.println("all product tab - Validation done");
	}
	
	@Test(enabled=true)
	public void electronicTabClickable() {
		hp.clickElectronicTab();
		Assert.assertEquals(hp.isElectronicTabClickable(),"Product is not clicked");
		System.out.println("Electronic tab - Validation done");
	}
	
	@Test(enabled=true)
	public void fashionTabClickable() {
		hp.clickFashionTab();
		Assert.assertEquals(hp.isFashionTabClickable(), "Product is not clicked");
		System.out.println("Fashion tab - Validation done");
	}
	
	@Test(enabled=true)
	public void homeAndGardenTabClickable() {
		hp.clickHomeandGardenTab();
		Assert.assertEquals(hp.homeAndGardenTabClickable(), "Product is not clicked");
		System.out.println("Home and Garden Tab - Validation done");
	}
}