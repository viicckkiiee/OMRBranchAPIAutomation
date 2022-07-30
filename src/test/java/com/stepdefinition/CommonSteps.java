package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import cucumber.api.java.en.Then;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To have common snippets from the feature files
 *
 */
public class CommonSteps extends BaseClass{
	
	@Then("User should verify the status code is {int}")
	/**
	 * 
	 * @param int1
	 * @CreationDate 26/06/2022
	 * @Description To verify response status code 
	 */
	public void userShouldVerifyTheStatusCodeIs(int int1) {
		
		Assert.assertEquals("Verify static status code",LoginStep.statusCode, int1);
		Assert.assertEquals("Verify getStatusCode()",LoginStep.cm.getStatusCode(), int1);
		
	}


}
