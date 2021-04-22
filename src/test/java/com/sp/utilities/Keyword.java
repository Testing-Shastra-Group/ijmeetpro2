package com.sp.utilities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	public WebDriver driver = null;

	/**
	 * Use this method to launch specified browser. Browser name must be the one of
	 * following. This method doesn't supports browsers other than specified list.
	 * <ul>
	 * <li>Chrome</li>
	 * <li>Firefox</li>
	 * <li>Safari</li>
	 * <li>IE</li>
	 * <li>Headless</li>
	 * 
	 * @param browserName Browser Name must be one of the mentioned.
	 */
	public void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Constants.ldriver=driver;
			System.out.println("Opening Chrome Browser");

			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Opening Firefox Browser");
			break;
		case "Safari":
			driver = new SafariDriver();
			System.out.println("Opening Safari Browser");
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("Opening IE Browser");
			break;
		case "Headless":
			driver = new HtmlUnitDriver();
			System.out.println("Opening Headless Browser");
			break;
		default:
			System.out.println("Invalid Browser Name:" + browserName);
			break;
		}
	}

	public void launchUrl(String url) {
		driver.get(url);
		System.out.println("Launching url:" + url);
		
	}

	private WebElement getWebElement(String locator, String locatorType) {
		WebElement element = null;
		switch (locatorType) {
		case "XPATH":
			element = driver.findElement(By.xpath(locator));
			break;
		case "CSS":
			element = driver.findElement(By.cssSelector(locator));
			break;
		case "ID":
			element = driver.findElement(By.id(locator));
			break;
		case "CLASS":
			element = driver.findElement(By.className(locator));
			break;
		default:
			break;
		}

		return element;
	}

	public void click(String locator, String locatorType) {
		getWebElement(locator, locatorType).click();
	}

	public void enterText(String locator, String locatorType, String text) {
		getWebElement(locator, locatorType).sendKeys(text);
	}

	public String getTextOfElement(String locator, String locatorType) {
		return getWebElement(locator, locatorType).getText();

	}
}
