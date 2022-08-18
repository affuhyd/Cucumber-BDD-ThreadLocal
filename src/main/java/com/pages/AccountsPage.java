package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	private By accountSections = By.cssSelector("div#center_column span");
	
		
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int  getAccountsSectionCount() {
		return driver.findElements(accountSections).size()-1;
	}
	public List<String> getAccountsSectionsList() {
		List<String> accList = new ArrayList<>();
		List<WebElement> accountsList = driver.findElements(accountSections);
		for(WebElement e : accountsList) {
			accList.add(e.getText());
		}
		return accList;
	}
	public String getTitle() {
		return driver.getTitle();
	}
}
