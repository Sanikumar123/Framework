package com.zoho.signuppage.suitepack;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.af.testbase.TestBase;
import com.af.utility.Constants;
import com.af.utility.DataProviders;
import com.af.utility.DriverFactory;
import com.af.zohosignuppage.ZohoSignUpPageClass;

public class ZohoSignUpTestPage extends TestBase {
	
    ZohoSignUpPageClass zohoSignUp;
	
	
	@BeforeMethod
	public void initialization()
	{
		launchBrowser();
		zohoSignUp = new ZohoSignUpPageClass();
	}
	
	@Test
	public void validateZohoHomepageTitle()
	{
		zohoSignUp.verifySignUpPageTitle(Constants.EXPECTED_TITLE);
	}
	
	
	
	
	
	@AfterMethod
	public void quit()
	{
		tearDown();
	}



}
