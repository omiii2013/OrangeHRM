package com.orangehrm.pages.login;

import org.openqa.selenium.WebElement;

import com.orangehrm.CommonFunctions;
import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.login.employeemanagement.EmployeeManagement;

public class Login extends BaseClass implements Login_OR{
	
	/**
	 * Enter the login details for Orange HRM
	 * @param id	as userName
	 * @param pass	as password
	 * @return Home page object i.e. EmployeeManagement
	 */
	public EmployeeManagement enterLoginDetails(String id, String pass) {
		
		// Enter username
		cf.setValue(username, id);
		
		// Enter password
		cf.setValue(password, pass);
		
		// Click Login button
		cf.onClick(loginBtn);
		
		return new EmployeeManagement();
	}
	
	/**
	 * Verify that password logo functionality
	 */
	public void verifyPasswordIcon() {
		
		// Enter password and click on eye logo
		cf.setValue(password, "test");
		cf.onClick(passwordLogo);
		
		// Verify the password
		if(cf.isElementDisplayed(showPassword)) {
			System.out.println("Password is visible on the screen");
		}
		
	}
}
