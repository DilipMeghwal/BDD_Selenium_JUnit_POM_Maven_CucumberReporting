package com.duke.testRunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.duke.base.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resources/features"},
			glue = {"com.duke.stepDefinations"},
			monochrome = true,
			strict = true,
			//tags = {"@Regression"},
			plugin = {"pretty", "html:target/cucumber-reports", 
					"json:target/cucumber.json"}
		)
public class TestRunner{
	@BeforeClass
	public static void beforeClass() throws IOException {
		BaseClass.setUp();
	}
	
	@AfterClass
	public static void afterClass() {
		BaseClass.tearDown();
	}
}
