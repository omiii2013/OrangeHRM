package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	static public WebDriver driver;
	static Properties config;
	
	public BaseClass() {
		
		config = new Properties();
		
		try {
			config.load(new FileInputStream("src/config.properties"));
		} catch (FileNotFoundException e) {
			
			System.out.println("Can't able to find the config properties");
		} catch (IOException e) {
			
			System.out.println("Can't able to load the config properties");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void init() {
		
		String browser = config.getProperty("browser");
		
		switch (browser) {
		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", "/OrangeHRM/src/main/resources/chromedriver-mac-arm64/chromedriver");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", "/OrangeHRM/src/main/resources/geckodriver");
			driver = new FirefoxDriver();
			break;

		default:
			
			// Can add the default browser as Safari or Edge Browser
			break;
		}
		
		// Maximize the window and Delete all the cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(config.getProperty("url"));
		
	}
	
	
	
}