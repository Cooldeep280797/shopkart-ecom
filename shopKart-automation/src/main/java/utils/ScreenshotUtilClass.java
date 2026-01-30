package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ScreenshotUtilClass extends TestBase{

	public ScreenshotUtilClass(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public static void takeScreenshot(WebDriver driver, String fileName) {
		if(driver == null) {
			System.out.println("driver is Null = Can't capture Screenshot");
			return;
		}
		
		String timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folderPath = "D:\\AutomationTesting\\shopKart-automation";
		String filePath = folderPath + fileName + "_" + timestamp + ".png";
		try {
			FileHandler.copy(srcFile, new File(filePath));
			System.out.println("Screenshot Saved at: " + filePath);
		}
		catch(IOException e) {
			System.out.println("Please provide correct path");
			e.printStackTrace();
		}
	}
	
}
