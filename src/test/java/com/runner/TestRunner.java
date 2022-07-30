package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(snippets=SnippetType.CAMELCASE,strict=false,dryRun=false,plugin= {"pretty","json:target/cucumber.json"},monochrome=true,features="src/test/resources",glue="com.stepdefinition")
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To execute feature files and its step definition files
 *
 */
public class TestRunner {
		
		@AfterClass
		/**
		 * @CreationDate 26/06/2022
		 * @Description To generate JVM report after execution of TestRunnerClass
		 */
		public static void afterClass() {
			
			Reporting.generateJVMReport(System.getProperty("user.dir")+"\\target\\cucumber.json");
			
		}


}
