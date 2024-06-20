package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement username_field;
	@FindBy(xpath="//input[@id='password']")
	WebElement password_field;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement submit_button;
	
	public void enterUsername(String username)
	{
		username_field.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		password_field.sendKeys(password);
	}
	public HomePage clickonLoginButton()
	{
		submit_button.click();
		return new HomePage(driver);
	}
}
