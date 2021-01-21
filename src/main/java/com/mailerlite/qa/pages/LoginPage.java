package com.mailerlite.qa.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import com.mailerlite.qa.base.TestBase;

/*
 * Author: Imtiaz Mohammed
 * 
 * This is the Page class for Login Page for MailerLite App
 * 
 * Every Page class will contain the locators for its corresponding page
 * and the actions to be performed on the locators of the page
 * 
 * This page class is designed to automate the test of the login functionality
 * of the MailierLite App
 * 
 */

public class LoginPage extends TestBase	 {
	
	// Create Object Repository using Page Factory
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="submit-btn")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(), 'Sign up')]")
	WebElement signUpButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this); // initialize the locators\Page Objects on login page load
	}
	
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}
}
