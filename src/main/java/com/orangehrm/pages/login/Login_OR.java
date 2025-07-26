package com.orangehrm.pages.login;

import org.openqa.selenium.By;

public interface Login_OR {
	
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginBtn = By.xpath("//button[@type='submit']");
	By passwordLogo = By.xpath("//img[@title='Show Password']");
	By showPassword = By.xpath("//*[@id='txtPassword' and @type='text']");
}
