package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDatas;

public class HomePageTest extends Base {
	
	@Test
	public void verifyHomePageTitle()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
        LoginPage login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        HomePage home=login.clickonLoginButton();
        String homepage_title=home.getHomePageTitle();
		String expected_title=ExcelUtility.getStringData(0, 1, Constants.HOMEPAGE);
		Assert.assertEquals(homepage_title, expected_title, Messages.TITLEVALIDATION);

	}
	
	
	
	@Test
	public void verifyUserLoginDate()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		
        LoginPage login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        HomePage home=login.clickonLoginButton();

	}
	
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
	    home.clickOnProfileOption();
	    home.editLastName(new_lastname);
	    home.clickonUpdateButton();
	    String actual_editname=home.getUserProfileText();
	    String expected_editname=Constants.PROFILENAME+new_lastname;
	    Assert.assertEquals(actual_editname, expected_editname, Messages.PROFILE_EDITFAIL);
	    
	}
	

}
