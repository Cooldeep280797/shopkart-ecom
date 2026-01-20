package baseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageLayer.Homepage;
import pageLayer.LoginPage;
import pageLayer.RegisterPage;

public class Testbase_Class {

	public WebDriver driver;
	public LoginPage P;
	public RegisterPage rp;
	public Homepage hp;

	public void setup(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		} else {
			System.out.println("Error Loading browser Setup");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Admin/Downloads/deepseek_html_20260114_c0bed7.html#");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void tearDown() {
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Execption during driver.quit" + e.getMessage());
		}

	}
}