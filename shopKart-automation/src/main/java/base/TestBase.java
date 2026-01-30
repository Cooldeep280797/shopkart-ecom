package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import factory.DriverFactory;
import pageLayer.HomePage;
import pageLayer.LoginPage;
import pageLayer.ProductPage;
import pageLayer.RegisterPage;
import utils.ConfigReader;

public class TestBase {

	protected WebDriver driver;
	protected WebDriverWait wdw;
	protected LoginPage lp;
	protected RegisterPage rp;
	protected HomePage hp;
	protected ProductPage pp;
	protected Select s;
	
	@BeforeTest()
	public void setup() {
		System.out.println("Entered");
		String browser = ConfigReader.get("browser");
		String url = ConfigReader.get("baseUrl");

		driver = DriverFactory.initDriver(browser);
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		try {
			if(driver != null) {
			driver.quit();	
			driver = null;
			}
			
		}
		catch(Exception e) {
			System.out.println("Exception while quitting" + e.getMessage());
		}
		
	}
}