package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.LoginPage;
import page_object.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base {
	
	@Test(groups="Sanity")
	public void verifyResetPassword()
	{
		String email=ExcelUtility.getStringData(0, 1, Constants.RESETPAGE);
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickpnForgotPassword();
		reset.enterEmailAddress(email);
		reset.enterResetPassword();
		String actual_message=reset.getConformationMessage();
		String expected_message=ExcelUtility.getStringData(1, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_message, expected_message, Messages.INVALID_EMAIL);
		
	}
	
	@Test(groups="Smoke")
	public void verifyErrorMessageWithInvalidEmailidOnForgotPassword()
	{
		String email=ExcelUtility.getStringData(2, 1, Constants.RESETPAGE);
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickpnForgotPassword();
		reset.enterEmailAddress(email);
		reset.enterResetPassword();
		String actual_errormessage=reset.getErrorMessage();
		String expected_errormessage=ExcelUtility.getStringData(3, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_errormessage, expected_errormessage, Messages.VALID_EMAIL);
	}
	
	
	

}
