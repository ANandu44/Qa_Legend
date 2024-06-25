package utilities;

import org.openqa.selenium.WebElement;
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

}
