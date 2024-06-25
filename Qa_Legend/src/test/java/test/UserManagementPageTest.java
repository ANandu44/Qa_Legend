package test;

import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import utilities.ExcelUtility;

public class UserManagementPageTest extends Base{
	
	@Test
	public void verifyUsersOptionIsEnabled()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		HomePage home=login.clickonLoginButton();
		home.enterEndtour();
		UserManagementPage usermanage=home.clickUserManagement();
		usermanage.ifElementIsEnabled();
	}

}
