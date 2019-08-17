package test;

import org.testng.annotations.Test;

import com.af.utility.DataProviders;

public class Rough {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="LoginFB")
	public void test(String uname, String pass)
	{
		//launchBrowser();
		//DriverFactory.getDriver().findElement(By.id("email")).sendKeys(uname);
		//DriverFactory.getDriver().findElement(By.id("pass")).sendKeys(uname);
		
		System.out.println(uname);
		System.out.println(pass);
		
	}

}
