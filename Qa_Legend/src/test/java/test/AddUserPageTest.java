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
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDatas;

public class AddUserPageTest extends Base {
	
	@Test
	public void verifyAddUser()
	{
		String login_username=ExcelUtility.getStringData(0, 1, "Login_Page");
		String login_password=ExcelUtility.getIntegerData(1, 1, "Login_Page");
		
		String first_name=RandomDatas.getFirstName();
		String last_name=RandomDatas.getLastName();
		String email=first_name+"."+last_name+"@gmail.com";
		String username=first_name+"."+last_name;
		String password=first_name+"12"+last_name;
		
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
		//WebElement usertable=driver.findElement(By.xpath("//table[@id='users_table']/tbody/td[4]"));
		//String usertext=usertable.getText();
		//System.out.println(usertext);
		/*List<WebElement> rows=usertable.findElements(By.tagName("tr"));
		int rowsize=rows.size();
		for(int i=0;i<rowsize;i++)
		{
			String celltext=rows.get(i).getText();
			if(celltext.equals(email))
			{
				String actual_user=
			}
		}*/
		//String expected_user=email;
		//Assert.assertEquals(celltext, expected_user, "INVALID USER");
		
		
	}
	
	@Test
	public void verifyUserLoginWithNewlyAddedUser()
	{
	
		String login_username=ExcelUtility.getStringData(0, 1, "Login_Page");
		String login_password=ExcelUtility.getIntegerData(1, 1, "Login_Page");
		
		String first_name=RandomDatas.getFirstName();
		String last_name=RandomDatas.getLastName();
		String email=first_name+"."+last_name+"@gmail.com";
		String username=first_name+"."+last_name;
		String password=first_name+"12"+last_name;
		
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
		String expected_message="Welcome"+" "+first_name+",";
		Assert.assertEquals(actual_message, expected_message, "INVALID USER");
		
		
		
	}

}
