package com.af.utility;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private static String chromeDriverExePath;
	private static String geckoDriverExePath;
	private static String ieDriverExePath;
	private static String configPropertyFilePath;
	private static String gridPath;
	private static boolean isRemote;
	private static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		DriverFactory.driver = driver;
	}
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	
	
	
	public static String getConfigPropertyFilePath() {
		return configPropertyFilePath;
	}
	public static void setConfigPropertyFilePath(String configPropertyFilePath) {
		DriverFactory.configPropertyFilePath = configPropertyFilePath;
	}
	public static boolean isRemote() {
		return isRemote;
	}
	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	public static String getChromeDriverExePath() {
		return chromeDriverExePath;
	}
	public static void setChromeDriverExePath(String chromeDriverExePath) {
		DriverFactory.chromeDriverExePath = chromeDriverExePath;
	}
	public static String getGeckoDriverExePath() {
		return geckoDriverExePath;
	}
	public static void setGeckoDriverExePath(String geckoDriverExePath) {
		DriverFactory.geckoDriverExePath = geckoDriverExePath;
	}
	public static String getIeDriverExePath() {
		return ieDriverExePath;
	}
	public static void setIeDriverExePath(String ieDriverExePath) {
		DriverFactory.ieDriverExePath = ieDriverExePath;
	}



}
