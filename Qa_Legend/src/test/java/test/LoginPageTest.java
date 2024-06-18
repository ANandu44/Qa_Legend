package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import automation_core.Base;
import data_provider.Data_Providers;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	
	@Test
	public void verifyUserLoginWithValidCredentials()
	{
		WebElement username_field=driver.findElement(By.id("username"));
		username_field.sendKeys(ExcelUtility.getStringData(0, 1, "Login_Page"));
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(ExcelUtility.getIntegerData(1, 1, "Login_Page"));
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();
		WebElement login_message=driver.findElement(By.xpath("//section[@class='content-header']"));
		String actual_loginmessage=login_message.getText();
		String expected_loginmessage=ExcelUtility.getStringData(2, 1, "Login_Page");
		Assert.assertEquals(actual_loginmessage, expected_loginmessage, "INVALID USER");
		
	
	}
	
	@Test(dataProvider="InvalidUserCredentials",dataProviderClass=Data_Providers.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String username,String password)
	{
		WebElement username_field=driver.findElement(By.id("username"));
		username_field.sendKeys(username);
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(password);
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();
		WebElement error_message=driver.findElement(By.xpath("//span[@class='help-block']"));
		String actual_errormessage=error_message.getText();
		String expected_erroemessage=ExcelUtility.getStringData(3, 1, "Login_Page");
		Assert.assertEquals(actual_errormessage, expected_erroemessage, "VALID USER");
		
	}
}
