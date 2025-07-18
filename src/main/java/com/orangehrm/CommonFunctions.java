package com.orangehrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.orangehrm.base.BaseClass;

public class CommonFunctions extends BaseClass{
	 
	/**
	 * Get the single WebElement
	 */
	public WebElement getWebElement(By by) {
		
		return driver.findElement(by);
	}
	
	/**
	 * Get the list of WebElements 
	 * @param by as element locator
	 * @return
	 */
	public List<WebElement> getWebElements(By by) {
		
		return driver.findElements(by);
	}
	
	/**
	 * Enter the value in the textbox
	 */
	public void setValue(By by, String value) {
		
		driver.findElement(by).sendKeys(value);
	}
	
	/**
	 * Click method
	 * @param by as element locator
	 */
	public void onClick(By by) {
		
		driver.findElement(by).click();
	}
	
	/**
	 * Find out if element is displayed in page or not
	 * @param by as element locator
	 * @return element is displayed or not
	 */
	public boolean isElementDisplayed(By by) {
		
		return driver.findElement(by).isDisplayed();
	}
}
