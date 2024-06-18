package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import utilities.ExcelUtility;

public class ResetPageTest extends Base {
	
	@Test
	public void verifyResetPassword()
	{
		WebElement forgot_password=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgot_password.click();
		WebElement email_address=driver.findElement(By.xpath("//input[@id='email']"));
		email_address.sendKeys(ExcelUtility.getStringData(0, 1, "Reset_Page"));
		WebElement resetpassword_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		resetpassword_button.click();
		WebElement conformation_message=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String actual_message=conformation_message.getText();
		String expected_message=ExcelUtility.getStringData(1, 1, "Reset_Page");
		Assert.assertEquals(actual_message, expected_message, "INVALID EMAIL");
		
	}
	
	@Test
	public void verifyErrorMessageWithInvalidEmailidOnForgotPassword()
	{
		WebElement forgot_password=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgot_password.click();
		WebElement email_address=driver.findElement(By.xpath("//input[@id='email']"));
		email_address.sendKeys(ExcelUtility.getStringData(2, 1, "Reset_Page"));
		WebElement resetpassword_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		resetpassword_button.click();
		WebElement error_message=driver.findElement(By.xpath("//span[@class='help-block']"));
		String actual_errormessage=error_message.getText();
		String expected_errormessage=ExcelUtility.getStringData(3, 1, "Reset_Page");
		Assert.assertEquals(actual_errormessage, expected_errormessage, "VALID EMAIL");
	}
	
	
	

}
