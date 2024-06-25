package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	WebDriver driver;
	public MyProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement new_FirstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement new_LastName;
	
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement update_button;
	
	public void editFirstName(String new_firstname)
	{
		new_FirstName.clear();
		new_FirstName.sendKeys(new_firstname);
	}
	
	public void editLastName(String new_lastname)
	{
		new_LastName.clear();
		new_LastName.sendKeys(new_lastname);
	}
	
	public void clickonUpdateButton()
	{
		update_button.click();
	}

}
