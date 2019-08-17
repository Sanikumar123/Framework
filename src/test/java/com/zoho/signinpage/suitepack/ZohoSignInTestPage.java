package com.zoho.signinpage.suitepack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.af.testbase.TestBase;
import com.af.zohosignuppage.ZohoSignInPageClass;
import com.af.zohosignuppage.ZohoSignUpPageClass;

public class ZohoSignInTestPage extends TestBase {
	
	ZohoSignUpPageClass signUpPage;
	ZohoSignInPageClass signInPage;
	
	@BeforeMethod
	public void initialization()
	{
		launchBrowser();
		signUpPage  = new ZohoSignUpPageClass();
		signInPage = signUpPage.clickOnSignInBtn();
		
		
	}
	
	@Test
	public void validateSignIn()
	{
		signInPage.loginIn(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	
	
	@AfterMethod
	public void quit()
	{
		tearDown();
	}



}
