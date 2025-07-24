package com.orangehrm.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.CommonFunctions_OR;
import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.login.Login;
import com.orangehrm.pages.login.employeemanagement.EmployeeManagement;

public class EmployeeManagementTest extends BaseClass{
	
	Login login;
	EmployeeManagement employeeMng;
	
	public EmployeeManagementTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		init();
		login = new Login();
	}
	
	@Test
	public void loginDetailsTest() {
		
		employeeMng = login.enterLoginDetails(System.getProperty("username"), System.getProperty("password"));
	}
	
	@Test
	public void searchEmployee() {
		
		// Navigate to EmployeeManagement tab and verify it
		if(employeeMng.navigateAndVerifyTab("EmployeeManagement")) {
			
			// Search employee and Verify
			employeeMng.searchEmployeeAndVerify("Peter");
		}
		
	}
	
	@Test
	public void verifyHelpIcon() {
		
		// Navigate to EmployeeManagement tab and verify it
		if(employeeMng.navigateAndVerifyTab("EmployeeManagement")) {
					
			// Check help functionality
			employeeMng.helpFunctionality();
			}
	}
	
	@AfterMethod
	public void tearUp() {
		
		driver.close();
		driver.quit();
	}
}
