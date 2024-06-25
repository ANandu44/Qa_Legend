package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	
	public static void checkIsDisplayed(WebElement element)
	{
		boolean check=element.isDisplayed();
		System.out.println(check);
	}
	
	public static void checkIsSelected(WebElement element)
	{
		boolean check=element.isSelected();
		System.out.println(check);
	}
	
	public static void checkIsEnabled(WebElement element)
	{
		boolean check=element.isEnabled();
		System.out.println(check);
	}
	
	
	

}
