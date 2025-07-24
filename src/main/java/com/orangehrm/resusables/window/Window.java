package com.orangehrm.resusables.window;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.CommonFunctions;

public class Window extends CommonFunctions implements Window_OR{
	
	public void switchToWindow(int index) {
		
	    List<String> windows = new ArrayList<>(driver.getWindowHandles());	    
	    if (index < windows.size()) {
	    	
	        driver.switchTo().window(windows.get(index));
	        
	    } else {
	    	
	        throw new IllegalArgumentException("Window index out of range.");
	    }
	}

	public void verifyNewWindow(boolean... closeWindow) {
		
		boolean close = closeWindow.length > 0 ? closeWindow[0] : false;
	    
		String originalWindow = driver.getWindowHandle();
	    Set<String> allWindows = driver.getWindowHandles();

	    if (allWindows.size() > 1) {
	        for (String window : allWindows) {
	            if (!window.equals(originalWindow)) {
	                
	            	driver.switchTo().window(window);
	                break;
	            }
	        }
	    }
	    
	    if (close) {
	        driver.close();
	        driver.switchTo().window(originalWindow);
	    }
	}
	
	public void searchAndVerifyPageLoaded(By searchButton, By pageElement) {
		
	    driver.findElement(searchButton).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    try {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(pageElement));
	    } catch (TimeoutException e) {
	       
	    	throw new RuntimeException("Page did not load properly.");
	    }
	}

	public void clickAndVerifyNewWindow(By locator, String expectedTitle, boolean... closeWindow) {
		
		boolean close = closeWindow.length > 0 ? closeWindow[0] : false;
	    String originalWindow = driver.getWindowHandle();
	    
	    onClick(locator);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    Set<String> allWindows = driver.getWindowHandles();
	    
	    for (String window : allWindows) {
	        if (!window.equals(originalWindow)) {
	            driver.switchTo().window(window);
	            break;
	        }
	    }

	    if (!driver.getTitle().contains(expectedTitle)) {
	        throw new RuntimeException("Expected page not opened.");
	    }

	    if (close) {
	        driver.close();
	        driver.switchTo().window(originalWindow);
	    }
	}
	
	
}
