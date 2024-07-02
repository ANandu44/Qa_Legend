package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	static int index=3;
	public static void selectDropdownByIndex(WebElement element)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectDropdownByValue(WebElement element,String value)
	{
		Select select =new Select(element);
		select.selectByValue(value);	
	}
	
	public static void selectDropdownByVisibleText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void forSimpleAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public static void forConformationAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public static void forPromptAlert(WebDriver driver,String value)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();		
	}
	
	public static void actionForRightClick(WebElement element,WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	public static void actionForDoubleClick(WebElement element,WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	public static void actionForMouseHover(WebElement element,WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void actionForDragAndDrop(WebElement source_element,WebElement target_element, WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(source_element, target_element).build().perform();
	}
	
	
}
