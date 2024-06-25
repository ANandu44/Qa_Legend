package test;

import automation_core.Base;
import constants.Constants;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class UsersPageTest extends Base {
	public void verifySearchUser()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		
        LoginPage login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        HomePage home=login.clickonLoginButton();
	}
	

}
