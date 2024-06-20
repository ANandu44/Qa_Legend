package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import automation_core.Base;
import data_provider.Data_Providers;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	
	@Test
	public void verifyUserLoginWithValidCredentials()
	{
		
		String username=ExcelUtility.getStringData(0, 1, "Login_Page");
		String password=ExcelUtility.getIntegerData(1, 1, "Login_Page");
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		HomePage home=login.clickonLoginButton();
		String actual_loginmessage=home.getLoginText();
		String expected_loginmessage=ExcelUtility.getStringData(2, 1, "Login_Page");
		Assert.assertEquals(actual_loginmessage, expected_loginmessage, "INVALID USER");
		
	
	}
	
	@Test(dataProvider="InvalidUserCredentials",dataProviderClass=Data_Providers.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickonLoginButton();
		String actual_errormessage=login.getErrorMessage();
		String expected_erroemessage=ExcelUtility.getStringData(3, 1, "Login_Page");
		Assert.assertEquals(actual_errormessage, expected_erroemessage, "VALID USER");
		
	}
}
