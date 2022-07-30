package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.CommonVariables;
import com.pojo.Login_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To perform login function through API
 *
 */
public class LoginStep extends BaseClass{
	
	public static CommonVariables cm = new CommonVariables();
	
	static String logtoken;
	public static int statusCode;
	/**
	 * @CreationDate 26/06/2022
	 * @Description To add header
	 */
	@Given("User should add header")
	public void userShouldAddHeader() {
		
		addHeader("Content-Type","application/json");	
		
	}
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @CreationDate 26/06/2022
	 * @Description To add basic authorization for the login
	 */
	@Given("User should add basic authorization for login")
	public void userShouldAddBasicAuthorizationForLogin() throws FileNotFoundException, IOException {
		
		basicAuth(getPropertyFileValue("username"),getPropertyFileValue("password"));
		
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 26/06/2022
	 * @Description To send POST request to the login endpoint
	 */
	@When("User should send {string} request to login endpoint")
	public void userShouldSendRequestToLoginEndpoint(String string) {
		
		Response response = requestType("POST", EndPoints.LOGIN);
		statusCode = response.statusCode();
		System.out.println("Login Status Code : "+statusCode);
		cm.setStatusCode(statusCode);
		
	}

	/**
	 * 
	 * @param string
	 * @CreationDate 26/06/2022
	 * @Description To verify first name from the response body 
	 */
	@Then("User should verify the login response body firstName present as {string} and get the logtoken")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtoken(String string) {
		
		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		String first_name = login_Output_pojo.getData().getFirst_name();
		System.out.println("First Name : " +first_name);
		
		Assert.assertEquals(first_name, string, "verifying firstName");
		

		logtoken = login_Output_pojo.getData().getLogtoken();
	//	System.out.println(logtoken);
		
		cm.setLogtoken(logtoken);

		
	}

}
