package data_provider;

import org.testng.annotations.DataProvider;

public class Data_Providers {
	
	@DataProvider(name="InvalidUserCredentials")
	public Object[][] user_credentials_data()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="admin";              //correct User name and incorrect password
		data[0][1]="123";
		
		data[1][0]="administrator";      //incorrect user name and correct password
		data[1][1]="123456";
		
		data[2][0]="addmin";             //incorrect user name and password
		data[2][1]="4567";
		
		return data;
	}

}
