package com.af.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.af.utility.DriverFactory;

public class TestBase {
	private static FileInputStream fin;
	protected static Properties prop;
	private static WebDriver driver;
	public static boolean gridStatus = false;
	
	
	@BeforeSuite
	public void intialSetUp()
	{
	
		//Setting up Grid Path
		DriverFactory.setGridPath("http://192.168.0.4:5556/wd/hub");

				
	 DriverFactory.setConfigPropertyFilePath(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
	
	
	prop= new Properties();
	try {
		fin = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		prop.load(fin);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(prop.getProperty("BROWSER").equalsIgnoreCase("chrome"))
	{
		DriverFactory.setChromeDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
	}
	else if(prop.getProperty("BROWSER").equalsIgnoreCase("firefox"))
	{
		DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\geckodriver.exe");

	}

	
	}
	
	public void launchBrowser()
	{
		
		/*
		 * Launch respective browser based on requirement
		 * Intialize the WebDriver
		 * Set Implicit Wait
		 * Maximize Browser
		 * 
		 */
		
		
		DriverFactory.setRemote(gridStatus);
		if(DriverFactory.isRemote())
		{
		DesiredCapabilities cap = null;
		
		if(prop.getProperty("BROWSER").equals("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
		}
		else if(prop.getProperty("BROWSER").equals("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}
		else if(prop.getProperty("BROWSER").equals("ie"))
		{
			cap=DesiredCapabilities.internetExplorer();
			cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		try {
			driver= new RemoteWebDriver(new URL(DriverFactory.getGridPath()),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else
		{
		if(prop.getProperty("BROWSER").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverExePath());
		    driver = new ChromeDriver();
		}
		else if(prop.getProperty("BROWSER").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckoDriverExePath());
		    driver = new FirefoxDriver();
		}
		}
		
        DriverFactory.setDriver(driver);
		
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(prop.getProperty("testsiteurl"));
		}
	
	public static void tearDown()
	{
		/*
		 * Quit Browser
		 */
		
		DriverFactory.getDriver().quit();
	}



}
