package com.orangehrm.pages.login;

import org.openqa.selenium.WebElement;

import com.orangehrm.CommonFunctions;
import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.login.employeemanagement.EmployeeManagement;

public class Login extends CommonFunctions implements Login_OR{
	
	/**
	 * Enter the login details for Orange HRM
	 * @param id	as userName
	 * @param pass	as password
	 * @return Home page object i.e. EmployeeManagement
	 */
	public EmployeeManagement enterLoginDetails(String id, String pass) {
		
		// Enter username
		setValue(username, id);
		
		// Enter password
		setValue(password, pass);
		
		// Click Login button
		onClick(loginBtn);
		
		return new EmployeeManagement();
	}
	
	/**
	 * Verify that password logo functionality
	 */
	public void verifyPasswordIcon() {
		
		// Enter password and click on eye logo
		setValue(password, "test");
		onClick(passwordLogo);
		
		// Verify the password
		if(isElementDisplayed(showPassword)) {
			System.out.println("Password is visible on the screen");
		}
		
	}
}
