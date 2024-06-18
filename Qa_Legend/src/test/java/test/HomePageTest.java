package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	
	@Test
	public void verifyHomePageTitle()
	{
		WebElement username_field=driver.findElement(By.id("username"));
		username_field.sendKeys(ExcelUtility.getStringData(0, 1, "Login_Page"));
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(ExcelUtility.getIntegerData(1, 1, "Login_Page"));
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();
		WebElement end_tour=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		end_tour.click();
		String homepage_title=driver.getTitle();
		System.out.println(homepage_title);
		String expected_title=ExcelUtility.getStringData(0, 1, "Home_Page");
		Assert.assertEquals(homepage_title, expected_title, "INVALID TITLE");

	}
	
	@Test
	public void verifyPurchaseAndSalesInWeek()
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement username_field=driver.findElement(By.id("username"));
		username_field.sendKeys(ExcelUtility.getStringData(0, 1, "Login_Page"));
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(ExcelUtility.getIntegerData(1, 1, "Login_Page"));
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		WebElement end_tour=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		//wait.until(ExpectedConditions.visibilityOf(end_tour));
		end_tour.click();
		//WebElement this_week=driver.findElement(By.xpath("//label[@class='btn btn-info active'"));
		//this_week.click();
		
		
	}
	
	@Test
	public void verifyUserLoginDate()
	{
		WebElement username_field=driver.findElement(By.id("username"));
		username_field.sendKeys(ExcelUtility.getStringData(0, 1, "Login_Page"));
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(ExcelUtility.getIntegerData(1, 1, "Login_Page"));
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();
		WebElement end_tour=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		end_tour.click();
		WebElement date=driver.findElement(By.xpath("//div[@class='m-8 pull-left mt-15 hidden-xs']"));
		String actual_date=date.getText();
		
	}
	

}
