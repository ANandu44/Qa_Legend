package automation_core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
import org.testng.annotations.Parameters;

import constants.Constants;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fs;
	public void initializeBrowser(String browser)
	{
		prop=new Properties();
		try {
			fs=new FileInputStream(Constants.CONFIG_FILE);
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void setup(String browser_name)
	{
		initializeBrowser(browser_name);
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		  {
			  takeScreenShot(result);
		  }
		driver.close();
	}
	
	 public void takeScreenShot(ITestResult result) throws IOException
	{
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File screenshot=takesscreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./ScreenShot/"+result.getName()+".png"));
			
			
			
	}
	
	

}
