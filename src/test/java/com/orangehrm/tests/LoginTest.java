package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.pages.login.Login;
import com.orangehrm.pages.login.employeemanagement.EmployeeManagement;

public class LoginTest extends BaseTest{
	
	Login login;
	EmployeeManagement employeeMng;
	
	public LoginTest() {
		super();
	}
	
	@Test
	public void loginDetailsTest() {
		
		employeeMng = login.enterLoginDetails(System.getProperty("username"), System.getProperty("password"));
	}
	
	@Test
	public void validatePasswordIconTest() {
		
		login.verifyPasswordIcon();
	}
}
