package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDatas;

public class AddUserPageTest extends Base {
	
	@Test
	public void verifyAddUser()
	{
		String login_username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String login_password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		
		String first_name=RandomDatas.getFirstName();
		String last_name=RandomDatas.getLastName();
		String email=first_name+Messages.DOT+last_name+Messages.GMAIL_EXTENSION;
		String username=first_name+Messages.DOT+last_name;
		String password=first_name+Messages.RANDOM_NUMBERS+last_name;
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(login_username);
		login.enterPassword(login_password);
		HomePage home=login.clickonLoginButton();
		home.enterEndtour();
		home.clickUserManagement();
		AddUserPage adduser=home.clickUsersOption();
		adduser.clickAddUserButton();
		adduser.enterFirstName(first_name);
		adduser.enterLastName(last_name);
		adduser.enterEmail(email);
		adduser.selectFromDropdown();
		adduser.enterUserName(username);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSaveButton();
		adduser.searchOnSearchField(email);
		
		
	}
	
	@Test
	public void verifyUserLoginWithNewlyAddedUser()
	{
	
		String login_username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String login_password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		
		String first_name=RandomDatas.getFirstName();
		String last_name=RandomDatas.getLastName();
		String email=first_name+Messages.DOT+last_name+Messages.GMAIL_EXTENSION;
		String username=first_name+Messages.DOT+last_name;
		String password=first_name+Messages.RANDOM_NUMBERS+last_name;
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(login_username);
		login.enterPassword(login_password);
		HomePage home=login.clickonLoginButton();
		home.enterEndtour();
		home.clickUserManagement();
		AddUserPage adduser=home.clickUsersOption();
		adduser.clickAddUserButton();
		adduser.enterFirstName(first_name);
		adduser.enterLastName(last_name);
		adduser.enterEmail(email);
		adduser.selectFromDropdown();
		adduser.enterUserName(username);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSaveButton();
		adduser.waitForTextToBeInvisible();
		home.clickUserLogout();
		home.clickLogoutButton();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickonLoginButton();
		String actual_message=home.getLoginText();
		String expected_message=Messages.GREETINGS+first_name+Messages.COMMA;
		Assert.assertEquals(actual_message, expected_message, Messages.LOGINFAILED);
		
		
		
	}

}
