package com.sp.stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sp.pageObjects.SignUpPage;
import com.sp.utilities.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpStep {

	WebDriver driver;
	Scenario scenario;
	SignUpPage sup = new SignUpPage(driver);

	@Before()
	public void testSetup(Scenario scenario) {
		this.scenario = scenario;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Test Enviornment Set Up");
		System.out.println("-------------------------------------------------");
		System.out.println("Executing Scenario:" + scenario.getName());
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Given("I've a valid set of data and access to sign up page")
	public void userValiditycheck() {
		System.out.println("Navigating Sign Up Page");
		driver.get("https://ijmeet.com");
		driver.manage().window().maximize();
	}

	@When("Sign Up page Displayed")
	public void userOnsignup() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));
		WebElement signup = driver.findElement(By.linkText("Sign Up"));
		signup.click();

	}

	@Then("user enters {string},{string},{string},{string},{string} on sign up page")
	public void provideData(String username, String company, String emailid, String mobilenumber, String password) {
		System.out.println(username);
		sup.setFullName(username);
		sup.setCompanyName(company);
		sup.setUserEmail(emailid);
		sup.setMobileNumber(mobilenumber);
		sup.setPassword(password);

	}

	@Then("user clicks sign up button")
	public void user_clicks_sign_up_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
	}

}
