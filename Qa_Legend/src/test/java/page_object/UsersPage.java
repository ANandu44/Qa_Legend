package page_object;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UsersPage {
	WebDriver driver;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement add_user;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement search_field;
	
	@FindBy(className="toast-success")
	WebElement success_message;
	
	//@FindBy(xpath="//tr[@class='odd']//td[1]")
	@FindBy(xpath="//table[@id='users_table']//tbody//td[1]")
	WebElement search_row;
	
	public AddUserPage clickAddUserButton()
	{
		add_user.click();
		return new AddUserPage(driver);
	}
	
	
	public void searchOnSearchField(String username)
	{
		search_field.sendKeys(username);
	}
	
	public void waitForTextToBeInvisible()
	{
		WaitUtility.waitForElementToBeInvisible(driver, success_message);
	}
	
	public String getSearchUser()
	{
		String user=search_row.getText();
		return user;
	}
	

}
