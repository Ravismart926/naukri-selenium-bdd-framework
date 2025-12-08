package com.naukri.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.naukri.stepdefinitions",
		"com.naukri.hooks" }, plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber.json",
				"junit:target/cucumber.xml",
				"json:target/cucumber.json" }, monochrome = true, dryRun = false, tags = "@smoke")
public class TestRunner {

}