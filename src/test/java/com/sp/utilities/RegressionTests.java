package com.sp.utilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RegressionTests {


	@Test
	public void tc_01() {
		Keyword keyword = new Keyword();
		keyword.openBrowser(Constants.getProperties("Browser"));
		keyword.launchUrl(Constants.getProperties("url"));
		Constants.ldriver.manage().window().maximize();
		
		
	
	}

	@AfterTest
	private void tearDown() {
	Constants.ldriver.quit();

	}
}
