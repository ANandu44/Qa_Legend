package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;
	public ResetPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email_address;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement resetpassword_button;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement conformation_message;
	
	@FindBy(xpath="//span[@class='help-block']")
	WebElement error_message;
	
	
	public void enterEmailAddress(String email)
	{
		email_address.sendKeys(email);
	}
	
	public void enterResetPassword()
	{
		resetpassword_button.click();
	}
	public String getConformationMessage()
	{
		String message=conformation_message.getText();
		return message;
	}
	
	public String getErrorMessage()
	{
		String message=error_message.getText();
		return message;
	}

}
