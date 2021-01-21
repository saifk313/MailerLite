package com.mailerlite.qa.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import com.mailerlite.qa.util.TestUtil;

/*
 * Author: Imtiaz Mohammed
 * 
 * This is the Base class for all the Page Classes and the Test Classes for MailerLite App
 * 
 * All the Page and Test Classes will inherit the properties of this class.
 * 
 */

public class TestBase {

	public static WebDriver driver;
	public static Properties property;
	public static String propertyPath = "C:\\Users\\Dell\\eclipse-workspace\\MailerLiteAutomation\\src\\main\\java\\com\\mailerlite\\qa\\config\\config.properties";

	public TestBase() {
		try {
			property = new Properties();
			FileInputStream fis = new FileInputStream(propertyPath);
			property.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {
		property.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Installers\\chromedriver_v88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(property.getProperty("url"));
	}
}