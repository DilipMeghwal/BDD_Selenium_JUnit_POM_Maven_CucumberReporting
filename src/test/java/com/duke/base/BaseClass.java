package com.duke.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver = null;
	public static Properties config = new Properties();
	public static String projPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	static WebDriverWait wait;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUp() throws IOException {
		if(driver == null) {
			fis = new FileInputStream(projPath + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			
			//select browser
			if(config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(config.getProperty("testSiteUrl"));
			}else if(config.getProperty("browser").equals("firefox")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(config.getProperty("testSiteUrl"));
			}else if(config.getProperty("browser").equals("InternetExplorer")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.get(config.getProperty("testSiteUrl"));
			}
			
			wait = new WebDriverWait(driver, 20);
		}else {
			System.out.println("Driver is not null");
		}
	}
	
	public static void tearDown() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	//to check element is present or not
	public <T> boolean isElementPresent(T element){
		try {
			if(element.getClass().getName().contains("By")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
				driver.findElement((By)element).isDisplayed();
				return true;
			}else{
				wait.until(ExpectedConditions.visibilityOf((WebElement) element));
				((WebElement)element).isDisplayed();
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public <T> void setInputBoxText (T element, String text){
		try {
			if(element.getClass().getName().contains("By")) {
				driver.findElement((By)element).sendKeys(text);
			}else{
				((WebElement)element).sendKeys(text);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public <T> void clickOnElement (T element){
		try {
			if(element.getClass().getName().contains("By")) {
				wait.until(ExpectedConditions.elementToBeClickable((By) element));
				driver.findElement((By)element).click();
			}else{
				wait.until(ExpectedConditions.elementToBeClickable((WebElement) element));
				((WebElement)element).click();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public <T> String getTextOfElement(T element){
		try {
			if(element.getClass().getName().contains("By")) {
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) element));
				return driver.findElement((By)element).getText();
			}else{
				wait.until(ExpectedConditions.visibilityOf((WebElement) element));
				((WebElement)element).isDisplayed();
				return driver.findElement((By)element).getText();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public <T> void pressEnterKey(T element) {
		try {
			if(element.getClass().getName().contains("By")) {
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) element));
				driver.findElement((By)element).sendKeys(Keys.ENTER);
			}else{
				wait.until(ExpectedConditions.visibilityOf((WebElement) element));
				((WebElement)element).sendKeys(Keys.ENTER);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
