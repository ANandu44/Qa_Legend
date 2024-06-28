package test;

import org.testng.Assert;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import page_object.UsersPage;
import utilities.ExcelUtility;

public class UsersPageTest extends Base {
	public void verifySearchUser()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		String email_id=ExcelUtility.getStringData(0, 1, Constants.USERSPAGE);
		
        LoginPage login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        HomePage home=login.clickonLoginButton();
        home.enterEndtour();
		UserManagementPage usermanage=home.clickUserManagement();
		UsersPage users=usermanage.clickUsersOption();
		users.searchOnSearchField(email_id);
		String actual_user=email_id;
		String expected_user=users.getSearchUser();
		Assert.assertEquals(actual_user, expected_user, Messages.USER_MISMATCH);
        
	}
	

}
