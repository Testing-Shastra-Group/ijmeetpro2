package com.sp.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features/SignInPage.feature",
		glue= "com.sp.stepdefinations")
public class Runner extends AbstractTestNGCucumberTests{
	
}
