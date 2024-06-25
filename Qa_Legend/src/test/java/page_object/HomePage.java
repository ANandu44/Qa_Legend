package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//section[@class='content-header']")
	WebElement login_message;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endtour;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement user_logout;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement logout_button;
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management;
	
	@FindBy(xpath="//div[@class='pull-left']//a[@class='btn btn-default btn-flat']")
	WebElement profile_option;
	

	
	public String getLoginText()
	{
		String user_message=login_message.getText();
		return user_message;
	}
	
	public String getHomePageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public UserManagementPage clickUserManagement()
	{
		user_management.click();
		return new UserManagementPage(driver);
	}
	
	
	public void clickUserLogout()
	{
		user_logout.click();
	}
	
	public LoginPage clickLogoutButton()
	{
		logout_button.click();
		return new LoginPage(driver);
	}
	
	public void enterEndtour()
	{
		endtour.click();
	}
	
	public MyProfilePage clickOnProfileOption()
	{
		profile_option.click();
		return new MyProfilePage(driver);
	}
	
	
	public String getUserProfileText()
	{
		String profile_text=user_logout.getText();
		return profile_text;
	}
	
	
}
