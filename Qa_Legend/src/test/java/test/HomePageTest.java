package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	
	@Test
	public void verifyHomePageTitle()
	{
		String username=ExcelUtility.getStringData(0, 1, "Login_Page");
		String password=ExcelUtility.getIntegerData(1, 1, "Login_Page");
        LoginPage login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        HomePage home=login.clickonLoginButton();
        String homepage_title=home.getHomePageTitle();
		String expected_title=ExcelUtility.getStringData(0, 1, "Home_Page");
		Assert.assertEquals(homepage_title, expected_title, "INVALID TITLE");

	}
	
	
	
	@Test
	public void verifyUserLoginDate()
	{
		String username=ExcelUtility.getStringData(0, 1, "Login_Page");
		String password=ExcelUtility.getIntegerData(1, 1, "Login_Page");
        LoginPage login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        HomePage home=login.clickonLoginButton();
        String homepage_title=home.getHomePageTitle();
		String expected_title=ExcelUtility.getStringData(0, 1, "Home_Page");
		Assert.assertEquals(homepage_title, expected_title, "INVALID TITLE");
		//WebElement date=driver.findElement(By.xpath("//div[@class='m-8 pull-left mt-15 hidden-xs']"));
		//String actual_date=date.getText();
		
	}
	

}
