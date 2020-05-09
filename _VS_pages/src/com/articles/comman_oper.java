package com.articles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class comman_oper 
{
public static WebDriver driver;
public static WebDriverWait wait;
public static String exePath = "G:\\mobile app testing\\---------------------excel property file\\Browser_drivers\\";

//In this class we create comman operation (method) which require for project.  
//----------------------------------------------------------------------
//public static WebDriver Open_given_Browser(String broswerName)

public static void Open_given_Browser()
	{
	
	System.setProperty("webdriver.chrome.driver", exePath+"chromedriver.exe");
	driver=new ChromeDriver();
	
	//System.setProperty("webdriver.gecko.driver", exePath+"geckodriver.exe");
	//driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	wait=new WebDriverWait(driver,5);
	/*
	if(broswerName.equalsIgnoreCase("firefox"))
	{
		//System.setProperty("webdriver.chrome.driver", exePath+"geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,5);
	}
	else if(broswerName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", exePath+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,5);
	}
	else if(broswerName.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.chrome.driver", exePath+"IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,5);
	}
	return driver;*/
}

public static void Closebrowser()
{
	driver.close();
}
}
