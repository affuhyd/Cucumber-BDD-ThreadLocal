package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	/*
	 * 1. All private By locators 
	 * 2. Constructor of the Page Class
	 * 3. Page actions
	 * Use encapsulation with locators as private and Page actions to be public
	 */
	private WebDriver driver;
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInbtn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		  return driver.getTitle();
	}
	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public AccountsPage clickOnLogin() {
		driver.findElement(signInbtn).click();
		return new AccountsPage(driver);
	}
	
	}
