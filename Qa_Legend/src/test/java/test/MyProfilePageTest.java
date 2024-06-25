package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.MyProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDatas;

public class MyProfilePageTest extends Base {
	
	@Test
	public void verifyEditProfile()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		
		String new_firstname=RandomDatas.getFirstName();
		String new_lastname=RandomDatas.getLastName();
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	    HomePage home=login.clickonLoginButton();
	    home.enterEndtour();
	    home.clickUserLogout();
	    MyProfilePage profile=home.clickOnProfileOption();
	    profile.editLastName(new_lastname);
	    profile.clickonUpdateButton();
	    String actual_editname=home.getUserProfileText();
	    String expected_editname=Constants.PROFILENAME+new_lastname;
	    Assert.assertEquals(actual_editname, expected_editname, Messages.PROFILE_EDITFAIL);
	    
	}

}
