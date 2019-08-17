package com.af.zohosignuppage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.af.utility.DriverFactory;

public class ZohoSignUpPageClass {
	
	@FindBy(xpath="//*[@id='bloc-block-3']/div/div/div[3]/div[3]/a[1]")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='signupbtn']")
	WebElement getStartedbtn;
	
	public ZohoSignUpPageClass()
	{
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public void verifySignUpPageTitle(String expectedTitle)
	{
		String actualTitle = DriverFactory.getDriver().getTitle();

       Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public ZohoSignInPageClass clickOnSignInBtn()
	{
		loginBtn.click();
		return new ZohoSignInPageClass();
	}


}
