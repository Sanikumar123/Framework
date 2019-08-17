package com.af.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginFB")
	public Object[][] getData() throws Exception
	{
		 Object[][] data = ExcelReader.data("C:\\Users\\Sani\\Desktop\\FBLogin.xlsx");
		 return data;
		
	}

	
	}


