package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.login.Login;
import com.orangehrm.pages.login.employeemanagement.EmployeeManagement;

public class BaseTest extends BaseClass{
	
	public BaseTest() {
		super();
	}
	
	@BeforeSuite
	public void setUp() {
		
		init();
	}
	
	
	@AfterSuite
	public void tearUp() {
		
		driver.close();
		driver.quit();
	}
}
