package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.login.Login;
import com.orangehrm.pages.login.employeemanagement.EmployeeManagement;

public class LoginTest extends BaseClass{
	
	Login login;
	EmployeeManagement employeeMng;
	
	public LoginTest() {
		
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
	public void validatePasswordIconTest() {
		
		login.verifyPasswordIcon();
	}
	
	@AfterMethod
	public void tearUp() {
		
		driver.close();
		driver.quit();
	}
}
