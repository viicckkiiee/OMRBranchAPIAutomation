 package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.ChangeProfilePic_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
/**
 * 
 * @author vikki
 * @CreationDate 26/06/2022
 * @Description To add profile picture through RestAssured API
 *
 */
public class ProfilePicStep extends BaseClass {
	/**
	 * @CreationDate 26/06/2022
	 * @Description To add headers for profile picture
	 */
	@Given("User should add headers including multipart-form_data")
	public void userShouldAddHeadersIncludingMultipartFormData() {
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type","multipart/form-data");
		Header h2 = new Header("Authorization","Bearer " +LoginStep.logtoken);
		h.add(h1); h.add(h2);
		
		Headers headers = new Headers(h);
		addHeaders(headers);
		
	}
	/**
	 * @CreationDate 26/06/2022
	 * @Description To add form-data
	 */
	@Given("User should pass form-data")
	public void userShouldPassFormData() {
		
		multiPart();
		
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 26/06/2022
	 * @Description To send POST request to the uploadProfilePicture endpoint
	 */
	@When("User should send {string} request to UpdateProfilePic endpoint")
	public void userShouldSendRequestToUpdateProfilePicEndpoint(String string) {
		
		 response = requestType("POST", EndPoints.UPDATEPROFILEPIC);
		
	}
	/**
	 * 
	 * @param message
	 * @CreationDate 26/06/2022
	 * @Description To verify message from response body
	 */
	@Then("User should verify the updateProfilePic response body message matches {string}")
	public void userShouldVerifyTheUpdateProfilePicResponseBodyMessageMatches(String message) {
		
		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);
		String message1 = changeProfilePic_Output_Pojo.getMessage();
		System.out.println("Profile Update Verify Message : "+message1);
		Assert.assertEquals(message1, message, "Verify Profile updated Successfully");
		
	}


}
