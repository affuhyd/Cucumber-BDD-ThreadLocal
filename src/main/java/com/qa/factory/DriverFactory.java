package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/*
	 * Threadlocal gives an identical copy to every single thread, so we can execute parallel execution.
	 * If we use testNG, we have to wait for the first browser to execute and then the second browser will execute 
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: "+browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
	return	tlDriver.get();
	/*if you want all the threads that are using this method to be
	in sync, then use synchronized keyword */
	}
}
