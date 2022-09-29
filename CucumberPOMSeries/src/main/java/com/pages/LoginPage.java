package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	// 1. Create By Locators or Object Repository
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By SignIn = By.id("SubmitLogin");
	private By forgotpwdlnk = By.linkText("Forgot your password12?");
	
	// 2.Constructor of the page class:
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// 3. Page Actions : Features(behaviour) of the page the form of methods:
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotpasswordlinkExist() {
		return driver.findElement(forgotpwdlnk).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(SignIn).click();
	}
	
	public AccountsPage doLogin(String un, String pwd)
	{
		System.out.println("Login with: " +un+ " and " +pwd );
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignIn).click();
		
		return new AccountsPage(driver);
	}
	
	

}
