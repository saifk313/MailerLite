package com.mailerlite.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.mailerlite.qa.pages.HomePage;
import com.mailerlite.qa.pages.LoginPage;
import com.mailerlite.qa.util.TestUtil;
import com.mailerlite.qa.base.TestBase;

/*
*
* Author: Saif A Kazi
*
*/

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize(); // Call the initialize method to load browser and launch the app
		loginPage = new LoginPage();
	}
	
	@DataProvider(name="testData")
	public Object[][] getTestData() {
		Object[][] credentials = TestUtil.readDatafromExcel("Sheet1");
		return credentials;
	}
	
	@Test(dataProvider="testData")
	public void loginTest(String uname, String pwd) throws InterruptedException {
		homePage = loginPage.login(uname, pwd);
		Thread.sleep(3000);
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Dashboard | MailerLite", "Invalid Credentials");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
