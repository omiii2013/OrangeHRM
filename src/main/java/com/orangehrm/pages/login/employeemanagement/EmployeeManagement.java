package com.orangehrm.pages.login.employeemanagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orangehrm.pages.login.Login;
import com.orangehrm.resusables.pagination.Pagination;
import com.orangehrm.resusables.window.Window;

public class EmployeeManagement extends Login implements EmployeeManagement_OR{
	
	// filter box functionality
	
	// pagination functionality --- check all pages by clicking on individual page number
	
	// add employee functionality
	
	// different tabs like my info, announcements, more and other ones
	
	public boolean navigateAndVerifyTab(String pageName) {
		
		cf.onClick(cf.getXpath(tabName, pageName));
		
		boolean isTabPresent = cf.verifyTab(pageName);
		return isTabPresent;
	}
	
	public void searchEmployeeAndVerify(String empName) {
		
		// Verify the page
		if(cf.verifyTab("Employee Management") && cf.isElementDisplayed(searchBtn)) {
			
			// Enter the value and press Enter 
			cf.setValue(searchBtn, empName);
			cf.setValue(searchBtn, Keys.ENTER);
			
			// Wait for data to load
			WebElement loading = cf.getWebElement(cf.loadingBar);
			
			// Verify the data
			if(cf.waitForTableDataToLoad(ExpectedConditions.invisibilityOf(loading))) {
				
				if(cf.isElementDisplayed(cf.getXpath(empDataByName, empName)))
					System.out.println("Data is present and verified");
			}
		}
	}
	
	public void helpFunctionality() {
		
		if(cf.isElementDisplayed(helpBtn)) {
			
			window.clickAndVerifyNewWindow(helpBtn, "How to view my information – OrangeHRM", true);
		}
		
	}
}
