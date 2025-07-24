package com.orangehrm;

import org.openqa.selenium.By;

public interface CommonFunctions_OR {

	By pageTitle = By.xpath("(//div[@id='topbar']//li//div)[1]");
	By topbarTabName = By.xpath("//div[@id='topbar']//li//div[text()='%s']");
	By loadingBar = By.xpath("//div[@class='peg']");
	
}
