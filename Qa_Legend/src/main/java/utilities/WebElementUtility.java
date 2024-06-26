package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	
	public static boolean checkIsDisplayed(WebElement element)
	{
		boolean check=element.isDisplayed();
		return check;
	}
	
	public static boolean checkIsSelected(WebElement element)
	{
		boolean check=element.isSelected();
		return check;
	}
	
	public static boolean checkIsEnabled(WebElement element)
	{
		boolean check=element.isEnabled();
		return check;
	}
	
	
	

}
