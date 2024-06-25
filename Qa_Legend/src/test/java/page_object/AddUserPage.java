package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname_field;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastname_field;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email_field;
	
	@FindBy(xpath="//select[@id='role']")
	WebElement role_dropdown;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username_option;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement userpassword_field;
	
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirmpassword_field;
	
	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement save_button;
	

	
	public void enterFirstName(String first_name)
	{
		firstname_field.sendKeys(first_name);
	}
	
	public void enterLastName(String last_name)
	{
		lastname_field.sendKeys(last_name);
	}
	public void enterEmail(String email)
	{
		email_field.sendKeys(email);
	}
	
	public void selectFromDropdown()
	{
		PageUtility.selectDropdownByVisibleText(role_dropdown, "Specialist");
	}
		
	
	public void enterUserName(String username)
	{
		username_option.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		userpassword_field.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password)
	{
		confirmpassword_field.sendKeys(password);
	}
	
	public UsersPage enterSaveButton()
	{
		save_button.click();
		return new UsersPage(driver);
	}
	
	
}
