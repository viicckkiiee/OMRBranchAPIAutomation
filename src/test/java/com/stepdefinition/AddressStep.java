package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.payload.Payload;
import com.pojo.AddAddress_Output_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To perform Address related functions through API
 *
 */
public class AddressStep extends BaseClass{
	
	static String address_id;
	/**
	 * @CreationDate 26/06/2022
	 * @Description To add headers 
	 */
	@Given("User should add headers")
	public void userShouldAddHeaders() {
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type","application/json");
	//	Header h2 = new Header("Authorization","Bearer " +LoginStep.logtoken);
		Header h2 = new Header("Authorization","Bearer " +LoginStep.cm.getLogtoken()); 
		h.add(h1); h.add(h2);
		
		Headers headers = new Headers(h);
		addHeaders(headers);
		
	}
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @CreationDate 26/06/2022
	 * @Description To add request body for creating address
	 */
	@Given("User should add required data for adding the address  {string} , {string}, {string}, {string}, {int}, {int}, {int}, {string}, {string} and {string}")
	public void userShouldAddRequiredDataForAddingTheAddressAnd(String fName, String lName, String mobile, String apartment, int state, int city, int country, String zipCode, String address, String addressType) {
	

		addBody(Payload.createAddress(fName,lName,mobile,apartment,state,city,country,zipCode,address,addressType));
		
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 26/06/2022
	 * @Description To send POST request method to the addAddress endpoint
	 */
	@When("User should send {string} request to AddAddress endpoint")
	public void userShouldSendRequestToAddAddressEndpoint(String string) {
			
		 response = requestType("POST", EndPoints.ADDADDRESS);
		
	}
	/**
	 * 
	 * @param message
	 * @CreationDate 26/06/2022
	 * @Description To verify the message from response body and to save address id
	 */
	@Then("User should verify the addAddress response body message matches {string} and get the address id saved")
	public void userShouldVerifyTheAddAddressResponseBodyMessageMatchesAndGetTheAddressIdSaved(String message) {
		
		AddAddress_Output_Pojo output_Pojo = response.as(AddAddress_Output_Pojo.class);
		
		int id = output_Pojo.getAddress_id();
		address_id = String.valueOf(id);
		System.out.println("Address Id : "+address_id);
		
		String message1 = output_Pojo.getMessage();
		System.out.println("Add Address Verify Message : "+message1);
		
		Assert.assertEquals("verifying Address added successfully",message1, message);
		
	}
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @CreationDate 26/06/2022
	 * @Description To add request body for updating address
	 */
	@Given("User should add required data for updating the address  {string} , {string}, {string}, {string}, {int}, {int}, {int}, {string}, {string} and {string}")
	public void userShouldAddRequiredDataForUpdatingTheAddressAnd(String fName, String lName, String mobile, String apartment, int state, int city, int country, String zipCode, String address, String addressType) {
		
		addBody(Payload.changeAddress(address_id,fName,lName,mobile,apartment,state,city,country,zipCode,address,addressType));
		
	}

	/**
	 * 
	 * @param string
	 * @CreationDate 26/06/2022
	 * @Description To send PUT request method for the updateAddress endpoint
	 */
	@When("User should send {string} request to UpdateAddress endpoint")
	public void userShouldSendRequestToUpdateAddressEndpoint(String string) {

		 response = requestType("PUT", EndPoints.UPDATEADDRESS);
			
	}
	/**
	 * 
	 * @param message
	 * @CreationDate 26/06/2022
	 * @Description To verify message from the request body of update address
	 */
	@Then("User should verify the updateAddress response body message matches {string}")
	public void userShouldVerifyTheUpdateAddressResponseBodyMessageMatches(String message) {
		
		Response response = requestType("PUT", EndPoints.UPDATEADDRESS);
		UpdateAddress_Output_Pojo updateAddressOut = response.as(UpdateAddress_Output_Pojo.class);
		String message1 = updateAddressOut.getMessage();
		System.out.println("Update Address Verify Message : "+message1);
		
	//	Assert.assertEquals(message1, message, "verifying Address updated successfully");
		Assert.assertEquals("verifying Address updated successfully",message1, message);
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 26/06/2022
	 * @Description To send GET request type for the endpoint
	 */
	@When("User should send {string} request to getAddress endpoint")
	public void userShouldSendRequestToGetAddressEndpoint(String string) {
		

		 response = requestType("GET", EndPoints.GETADDRESS);
			
	}
	/**
	 * 
	 * @param message
	 * @CreationDate 26/06/2022
	 * @Description To verify message from response body of Get address
	 */
	@Then("User should verify the getaddress response body message matches {string}")
	public void userShouldVerifyTheGetaddressResponseBodyMessageMatches(String message) {

		
		GetAddress_Output_Pojo getAddress = response.as(GetAddress_Output_Pojo.class);
		String message1 = getAddress.getMessage();
		System.out.println("Get Address Verify Message : "+message1);
	//	Assert.assertEquals(message1, message,"Verify");
		Assert.assertEquals("Verify",message1, message);
	
	}
	/**
	 * @CreationDate 26/06/2022
	 * @Description To add request body for deleteAddress
	 */
	@Given("User should add addressId in request body for deleting the address")
	public void userShouldAddAddressIdInRequestBodyForDeletingTheAddress() {
		
		addBody(Payload.deleteAddress(address_id));
		
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 26/06/2022
	 * @Description To send DELETE request to the endpoint
	 */
	@When("User should send {string} request to deleteaddress endpoint")
	public void userShouldSendRequestToDeleteaddressEndpoint(String string) {
		
		 response = requestType("DELETE", EndPoints.DELETEADDRESS);
		
	}
	/**
	 * 
	 * @param message
	 * @CreationDate 26/06/2022
	 * @Description To verify response body of deleteAddress
	 */
	@Then("User should verify the deleteAddress response body message matches {string}")
	public void userShouldVerifyTheDeleteAddressResponseBodyMessageMatches(String message) {
		
		DeleteAddress_Output_Pojo deleteAddressOutput= response.as(DeleteAddress_Output_Pojo.class);
		String message1 = deleteAddressOutput.getMessage();
		System.out.println("Delete Address Verify Message : "+message1);
	//	Assert.assertEquals(message1, message,"Verify Address deleted successfully");	
		Assert.assertEquals("Verify Address deleted successfully",message1, message);
	}


}
