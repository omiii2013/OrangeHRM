package com.orangehrm.pages.login;

import org.openqa.selenium.WebElement;

import com.orangehrm.CommonFunctions;
import com.orangehrm.base.BaseClass;

public class Login extends CommonFunctions implements Login_OR{
	
	/**
	 * Enter the login details for Orange HRM
	 */
	public void enterLoginDetails() {
		
		// Enter username
		setValue(username, System.getProperty("username"));
		
		// Enter password
		setValue(password, System.getProperty("password"));
		
		// Click Login button
		onClick(loginBtn);
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
