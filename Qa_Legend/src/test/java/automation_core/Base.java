package automation_core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;
	public void initializeBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new RuntimeException("INVALID BROWSER");
		}
		driver.get("https://qalegend.com/billing/public/login");
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initializeBrowser("Chrome");
	}
	
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();
	}
	
	

}