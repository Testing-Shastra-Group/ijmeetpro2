package com.sp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sp.utilities.Constants;




public class SigninPage {
 
	WebDriver ldriver;
	
	public SigninPage() {
	
		ldriver=Constants.ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(id ="email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(name ="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	@CacheLookup
	WebElement beforelnSignin;
	
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement afterlnSignin;
	
	@FindBy(xpath = "//a[@class='dropdown-item']")
	WebElement lnkLogout;
	
	@FindBy(id="profileDropdown")
	WebElement profileDropdown;

	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	
	public void beforeclickSignin() {
		beforelnSignin.click();
	}
	
	public void afterclickSignin() {
		afterlnSignin.click();
	}
	

	public void clickLogout() throws InterruptedException {
		profileDropdown.click();
		Thread.sleep(2000);
		lnkLogout.click();
    	 
	}

}
