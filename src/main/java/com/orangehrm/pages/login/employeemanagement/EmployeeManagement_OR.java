package com.orangehrm.pages.login.employeemanagement;

import org.openqa.selenium.By;

public interface EmployeeManagement_OR {

	By empTable = By.id("employeeListTable");
	By searchBtn = By.xpath("//input[contains(@id, 'employee_list')]");
//	By loadingBar = By.xpath("//div[@class='peg']");
	By empDataByName = By.xpath("//table[@id='employeeListTable']//a[contains(normalize-space(), '%s')]");
	By tabName = By.xpath("(//div[@id='menu-content']//span[contains(normalize-space(), '%s')]/parent::a)[1]");
	By helpBtn = By.xpath("//*[@id='ribbon-action-list']//help-button");
	
}
