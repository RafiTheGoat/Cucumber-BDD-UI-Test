package core;


import java.io.BufferedReader; 

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	// This class will help us read data from .properties files
	public static Properties properties; 
	// this class will help us to log each step of our execution
	public static Logger logger; 
	// this is path to config file where we specify the browser and URL
	//including full path as required by OS
	private String configPath = "/Users/owner/git/repository/us.bullish.test/src/test/resources/input/config.properties"; 
	private String log4jPath = "/Users/owner/git/repository/us.bullish.test/src/test/resources/input/log4j.properties"; // this is path to log4j file 
	
	
	public Base() {
		
	// we create an object of BufferedReader class to read values from the config file	
	try {
		
		BufferedReader reader = new BufferedReader(new FileReader(configPath));
		// we create object of Properties class
		properties = new Properties(); 
		// we call .load method and pass reader as argument 
		properties.load(reader); 
		// we want to close the reader so the input stream should be closed
		reader.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	logger = logger.getLogger(log4jPath);
	
	PropertyConfigurator.configure(log4jPath); 
		
	}
	
	
	
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url; 
	}
	/*
	 * This method will return the value of browser from config.properties file
	 */
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser; 
	}
	
	/*
	 * This method will launch the browser or open the browser 
	 */
	public static void launchBrowser() {
		driver.get(getUrl()); 
	}
	/*
	 * This method will close current and all open windows by Webdriver 
	 */
	public static void tearDown() {
		//driver.close();
		driver.quit();
	}
	
	/*
	 * Selecting a browser
	 */
	public void selectBrowser() {
		switch(getBrowser()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		//Managing Test window 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	

}