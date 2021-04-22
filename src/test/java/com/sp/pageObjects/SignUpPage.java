package com.sp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='name']")
	WebElement txtFullName;

	@FindBy(name = "company_name")
	WebElement txtCompanyName;

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(name = "contact")
	WebElement txtMobileNumber;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement InSignUp;
	
	

	public void setFullName(String name) {
		txtFullName.clear();
		txtFullName.sendKeys(name);
	}

	public void setCompanyName(String cname) {
		txtCompanyName.clear();
		txtCompanyName.sendKeys(cname);

	}

	public void setUserEmail(String id) {
		txtEmail.clear();
		txtEmail.sendKeys(id);
	}

	public void setMobileNumber(String number) {
		txtMobileNumber.clear();
		txtMobileNumber.sendKeys(number);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickSignUp() {
		InSignUp.click();
	}

}
