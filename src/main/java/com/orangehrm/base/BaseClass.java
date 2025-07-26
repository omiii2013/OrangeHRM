package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.CommonFunctions;
import com.orangehrm.pages.login.Login_OR;
import com.orangehrm.resusables.pagination.Pagination;
import com.orangehrm.resusables.window.Window;

public class BaseClass implements Login_OR{
	
	static public WebDriver driver;
	static Properties config;
	public static CommonFunctions cf;
	
	// Resusables instances
	public static Window window;
	public static Pagination pagination;
	
	public BaseClass() {
		
		config = new Properties();
		
		try {
			config.load(new FileInputStream("/Users/omii/Documents/GitHub/OrangeHRM/config.properties"));
		} catch (FileNotFoundException e) {
			
			System.out.println("Can't able to find the config properties");
		} catch (IOException e) {
			
			System.out.println("Can't able to load the config properties");
		}
		
	}
	
	public static void init() {
		
		String browser = config.getProperty("browser");
		
		switch (browser) {
		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", "/Users/omii/Documents/GitHub/OrangeHRM/Drivers/chromedriver-mac-x64/chromedriver");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", "/Users/omii/Documents/GitHub/OrangeHRM/Drivers/geckodriver");
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
		
		
		cf = new CommonFunctions(driver);
		window = new Window();
		pagination = new Pagination();
	}
	
	/**
	 * Enter the login details for Orange HRM
	 * @param id	as userName
	 * @param pass	as password
	 * @return Home page object i.e. EmployeeManagement
	 */
	public static <T> T login(Class<T> pageClass) {
		
		// Enter username
		String userID = config.getProperty("username");
		driver.findElement(username).sendKeys(userID);
		
		// Enter password
		String pass = config.getProperty("password");
		driver.findElement(password).sendKeys(pass);
		
		// Click Login button
		driver.findElement(loginBtn).click();
		
		try {
			
	        return pageClass.getDeclaredConstructor().newInstance(); // No driver passed
	    } catch (Exception e) {
	    	
	        throw new RuntimeException("Failed to instantiate page: " + pageClass.getName(), e);
	    }
	}
	
	
	
}