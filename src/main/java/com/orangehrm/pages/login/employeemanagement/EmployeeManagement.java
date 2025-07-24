package com.orangehrm.pages.login.employeemanagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orangehrm.pages.login.Login;
import com.orangehrm.resusables.pagination.Pagination;
import com.orangehrm.resusables.window.Window;

public class EmployeeManagement extends Login implements EmployeeManagement_OR{
	
	Window window;
	Pagination pagination;
	
	// filter box functionality
	
	// pagination functionality --- check all pages by clicking on individual page number
	
	// add employee functionality
	
	// different tabs like my info, announcements, more and other ones
	
	public boolean navigateAndVerifyTab(String pageName) {
		
		onClick(getXpath(tabName, pageName));
		
		boolean isTabPresent = verifyTab(pageName);
		return isTabPresent;
	}
	
	public void searchEmployeeAndVerify(String empName) {
		
		// Verify the page
		if(verifyTab("Employee Management") && isElementDisplayed(searchBtn)) {
			
			// Enter the value and press Enter 
			setValue(searchBtn, empName);
			setValue(searchBtn, Keys.ENTER);
			
			// Wait for data to load
			WebElement loading = getWebElement(loadingBar);
			
			// Verify the data
			if(waitForTableDataToLoad(ExpectedConditions.invisibilityOf(loading))) {
				
				if(isElementDisplayed(getXpath(empDataByName, empName)))
					System.out.println("Data is present and verified");
			}
		}
	}
	
	public void helpFunctionality() {
		
		if(isElementDisplayed(helpBtn)) {
			
			window.clickAndVerifyNewWindow(helpBtn, "How to view my information – OrangeHRM", true);
		}
		
	}
}
