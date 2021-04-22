package com.sp.stepdefinations;


import org.testng.Assert;
import com.sp.pageObjects.SigninPage;
import com.sp.utilities.Constants;
import com.sp.utilities.Keyword;

import io.cucumber.java.en.*;

public class SignInStep {

	public SigninPage sp;

	@Given("User launch browser")
	public void launchBrowser() {
		sp = new SigninPage();
		Keyword k = new Keyword();
		k.openBrowser(Constants.getProperties("Browser"));
		// System.out.println(Constants.getProperties("url"));
	}

	@When("User opens URL of IJMeet")
	public void user_opens_url() {
		Constants.ldriver.get(Constants.getProperties("url"));
		Constants.ldriver.manage().window().maximize();
		sp.beforeclickSignin();

	}

	@When("User enters Email as valid and password as valid")
	public void user_enters_email_as_and_password_as() {
		sp.setUserName(Constants.getProperties("Email"));
		sp.setPassword(Constants.getProperties("Password"));
	}

	@When("User click on sign in")
	public void clickonSignIn() {
		sp.afterclickSignin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String CurrentUrl) {

		if (Constants.ldriver.getPageSource().contains("These credentials do not match our records.")) {
			Constants.ldriver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(CurrentUrl, Constants.ldriver.getCurrentUrl());
		}
	}

	@When("user click logout link")
	public void user_click_logout_link() throws InterruptedException {

		sp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		Constants.ldriver.quit();
	}
}
