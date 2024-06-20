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
import utilities.ExcelUtility;
import utilities.RandomDatas;

public class AddUserPageTest extends Base {
	
	@Test
	public void verifyAddUser()
	{
		String first_name=RandomDatas.getFirstName();
		String last_name=RandomDatas.getLastName();
		String email=first_name+"."+last_name+"@gmail.com";
		String password=first_name+"12"+last_name;
		WebElement username_field=driver.findElement(By.id("username"));
		username_field.sendKeys(ExcelUtility.getStringData(0, 1, "Login_Page"));
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(ExcelUtility.getIntegerData(1, 1, "Login_Page"));
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();
		WebElement end_tour=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		end_tour.click();
		WebElement user_management=driver.findElement(By.xpath("//span[text()='User Management']"));
		user_management.click();
		WebElement user_option=driver.findElement(By.xpath("//span[@class='title'and contains(text(),'Users')]"));
		user_option.click();
		WebElement add_user=driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']"));
		add_user.click();
		WebElement prefix_field=driver.findElement(By.xpath("//input[@id='surname']"));
		prefix_field.sendKeys(prefix);
		WebElement firstname_field=driver.findElement(By.xpath("//input[@id='first_name']"));
		firstname_field.sendKeys(first_name);
		WebElement lastname_field=driver.findElement(By.xpath("//input[@id='last_name']"));
		lastname_field.sendKeys(last_name);
		WebElement email_field=driver.findElement(By.xpath("//input[@id='email']"));
		email_field.sendKeys(email);
		WebElement role_dropdown=driver.findElement(By.xpath("//select[@id='role']"));
		Select select=new Select(role_dropdown);
		select.selectByIndex(3);
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(first_name);
		WebElement userpassword_field=driver.findElement(By.xpath("//input[@id='password']"));
		userpassword_field.sendKeys(password);
		WebElement confirmpassword_field=driver.findElement(By.xpath("//input[@id='confirm_password']"));
		confirmpassword_field.sendKeys(password);
		//WebElement salescommission_field=driver.findElement(By.xpath("//input[@id='cmmsn_percent']"));
		WebElement save_button=driver.findElement(By.xpath("//button[@id='submit_user_button']"));
		save_button.click();
		WebElement search_field=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
		search_field.sendKeys(email);
		WebElement usertable=driver.findElement(By.xpath("//table[@id='users_table']/tbody/td[4]"));
		String usertext=usertable.getText();
		System.out.println(usertext);
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
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		String first_name=RandomDatas.getFirstName();
		String last_name=RandomDatas.getLastName();
		String email=first_name+"."+last_name+"@gmail.com";
		String username=first_name+"."+last_name;
		String password=first_name+"12"+last_name;
		WebElement username_field=driver.findElement(By.id("username"));
		username_field.sendKeys(ExcelUtility.getStringData(0, 1, "Login_Page"));
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(ExcelUtility.getIntegerData(1, 1, "Login_Page"));
		WebElement submit_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();
		WebElement end_tour=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		end_tour.click();
		WebElement user_management=driver.findElement(By.xpath("//span[text()='User Management']"));
		user_management.click();
		WebElement user_option=driver.findElement(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]"));
		user_option.click();
		WebElement add_user=driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']"));
		add_user.click();
		WebElement firstname_field=driver.findElement(By.xpath("//input[@id='first_name']"));
		firstname_field.sendKeys(first_name);
		WebElement lastname_field=driver.findElement(By.xpath("//input[@id='last_name']"));
		lastname_field.sendKeys(last_name);
		WebElement email_field=driver.findElement(By.xpath("//input[@id='email']"));
		email_field.sendKeys(email);
		WebElement role_dropdown=driver.findElement(By.xpath("//select[@id='role']"));
		Select select=new Select(role_dropdown);
		select.selectByIndex(3);
		WebElement username_option=driver.findElement(By.xpath("//input[@id='username']"));
		username_option.sendKeys(username);
		WebElement userpassword_field=driver.findElement(By.xpath("//input[@id='password']"));
		userpassword_field.sendKeys(password);
		WebElement confirmpassword_field=driver.findElement(By.xpath("//input[@id='confirm_password']"));
		confirmpassword_field.sendKeys(password);
		//WebElement salescommission_field=driver.findElement(By.xpath("//input[@id='cmmsn_percent']"));
		WebElement save_button=driver.findElement(By.xpath("//button[@id='submit_user_button']"));
		save_button.click();
		driver.navigate().to("https://qalegend.com/billing/public/home");
		WebElement userlogout=driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		//wait.until(ExpectedConditions.visibilityOf(userlogout));
		userlogout.click();
		WebElement logout_button=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		logout_button.click();
		WebElement username_field2=driver.findElement(By.id("username"));
		username_field2.sendKeys(username);
		WebElement password_field2=driver.findElement(By.xpath("//input[@id='password']"));
		password_field2.sendKeys(password);
		WebElement submit_button2=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button2.click();
		WebElement welcome_message=driver.findElement(By.xpath("//section[@class='content-header']"));
		String actual_message=welcome_message.getText();
		String expected_message="Welcome"+" "+first_name+",";
		Assert.assertEquals(actual_message, expected_message, "INVALID USER");
		
		
		
	}

}
