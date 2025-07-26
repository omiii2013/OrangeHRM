package com.orangehrm;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.resusables.window.Window;


public class CommonFunctions implements CommonFunctions_OR{
	
	WebDriver driver;
	Window window;
	
	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
		this.window = new Window();
	}
	 
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
	
	public By getXpath(By by, String... values) {
		
		String xpath = by.toString();
		
		if (xpath.startsWith("By.xpath: ")) {
	        xpath = xpath.replace("By.xpath: ", "");
	    } else {
	        throw new IllegalArgumentException("Only By.xpath is supported.");
	    }

	    // Format the XPath with dynamic values
	    String formattedXPath = String.format(xpath, (Object[]) values);
		
		return By.xpath(formattedXPath);
	}
	
	/**
	 * Enter the value in the textbox
	 */
	public void setValue(By by, String value) {
		
		driver.findElement(by).sendKeys(value);
	}
	
	/**
	 * Sends a keyboard key (ENTER, TAB, etc.)
	 * @param by 	as element locator
	 * @param value	as keyboard key value 
	 */
	public void setValue(By by, Keys value) {
		
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
	 * JavaScript click method
	 * @param by as element locator
	 */
	public void javaScriptClick(By by) {
		
		WebElement element = getWebElement(by);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", element);
	}
	
	/**
	 * Find out if element is displayed in page or not
	 * @param by as element locator
	 * @return element is displayed or not
	 */
	public boolean isElementDisplayed(By by) {
		
		return driver.findElement(by).isDisplayed();
	}
	
	/**
	 * Find out if element is enabled in page or not
	 * @param by as element locator
	 * @return element is enabled or not
	 */
	public boolean isElementEnabled(By by) {
		
		return driver.findElement(by).isEnabled();
	}
	
	/**
	 * Find out if element is selected in dropdown or radio button
	 * @param by as element locator
	 * @return element is selected or not
	 */
	public boolean isElementSelected(By by) {
		
		return driver.findElement(by).isSelected();
	}
	
	
	public boolean waitForPageLoad() {
		
		// Wait for page to load using JS scripts
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.readyState").equals("complete");
	}
	
	
	
	public void clickAndWaitForElement(By clickLocator, ExpectedCondition<?> condition, int timeoutInSeconds) {
		
		// Click the element
	    driver.findElement(clickLocator).click();
	    
	    // Wait for particular element
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    wait.until(condition);
	    
	}
	
	public void clickAndWaitForPageLoad(By clickLocator, int...timeoutInSeconds) {
		
		int optional = timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : 10;
		
		// Click the element
		driver.findElement(clickLocator).click();
		    
		// Wait for page load to complete
		new WebDriverWait(driver, Duration.ofSeconds(optional))
		.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	public boolean clickAndVerifyTitle(By clickLocator, String expectedTitle) {
		
		// Click the element
		driver.findElement(clickLocator).click();
		
		clickAndWaitForPageLoad(clickLocator, null);
		
		// Get the title of the page
		String pageTitle = driver.getTitle();
		
		// Compare the pageTitle and ExpectedTitle
		return pageTitle.equalsIgnoreCase(pageTitle);
	}
	
	/**
	 * PROJECT-SPECIFIC: Click on tabs and verify the page
	 */
	public boolean clickAndVerifyPage(By clickTab) {
		
		driver.findElement(clickTab).click();
		
		WebElement element = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		
		return element.isDisplayed();
	}
	
	/**
	 * PROJECT-SPECIFIC: Verify the tab
	 * @return tab is verified or not
	 */
	public boolean verifyTab(String tabName) {
		
		WebElement element = getWebElement(getXpath(CommonFunctions_OR.topbarTabName, tabName));
		
		return element.isDisplayed();
	}
	
	public boolean waitForTableDataToLoad(ExpectedCondition<?> condition, int...timeoutInSeconds) {
		
		int optional = timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : 10;
		
	    // Wait for particular element
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(optional));
	    
	    try{
	    	
	    	Object result = wait.until(condition);
	    	
	    	if(result instanceof Boolean)
	    		return (Boolean) result;
	    	
	    	return result != null;	    	
	    } catch (TimeoutException e) {
			
	    	return false;
		}
	}
	
	public void switchToDefaultContent() {
		
		driver.switchTo().defaultContent();
	}
	
	
}
