package com.omr.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.AddAddress_Output_Pojo;
import com.pojo.ChangeProfilePic_Output_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.Login_Output_pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import com.payload.Payload;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To perform GET/POST/PUT/DELETE actions in omrbranch.com through RestAssured
 *
 */
public class OMRBranchClub extends BaseClass{
	
	String logtoken;
	String address_id;
	
	@Test(priority=1)
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @CreationDate 26/06/2022
	 * @Description To perform login action
	 */
	public void login() throws FileNotFoundException, IOException {
		
	addHeader("Content-Type","application/json");	
	basicAuth(getPropertyFileValue("username"),getPropertyFileValue("password"));
	Response response = requestType("POST", EndPoints.LOGIN);
	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	
	Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
	String first_name = login_Output_pojo.getData().getFirst_name();
	System.out.println(first_name);
	
	Assert.assertEquals(statusCode, 200,"verifying status code");
	Assert.assertEquals(first_name, "Vignesh", "verifying firstName");
	
	logtoken = login_Output_pojo.getData().getLogtoken();
	//System.out.println(logtoken);
}
	@Test(priority=2)
	/**
	 * @CreationDate 26/06/2022
	 * @Description To add address
	 */
	public void addAddress() {
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type","application/json");
		Header h2 = new Header("Authorization","Bearer " +logtoken);
		h.add(h1); h.add(h2);
		
		Headers headers = new Headers(h);
		addHeaders(headers);
		
		addBody(Payload.createAddress("Mohan", "Dass", "11111222222", "Nest", 31, 3331, 101, "600060", "Trichy", "Office"));
		
		Response response = requestType("POST", EndPoints.ADDADDRESS);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		AddAddress_Output_Pojo output_Pojo = response.as(AddAddress_Output_Pojo.class);
		String message = output_Pojo.getMessage();
		System.out.println(message);
		
		int id = output_Pojo.getAddress_id();
		address_id = String.valueOf(id);
		System.out.println(address_id);
		
	}
	
	@Test(priority=3)
	/**
	 * @CreationDate 26/06/2022
	 * @Description To change the address
	 */
	private void updateAddress() {
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type","application/json");
		Header h2 = new Header("Authorization","Bearer " +logtoken);
		h.add(h1); h.add(h2);
		
		Headers headers = new Headers(h);
		addHeaders(headers);
		
		addBody(Payload.changeAddress(address_id, "Kumar", "Kumar", "99999888888", "Nest", 31, 3332, 101, "600060", "Chennai", "Home"));
		
		Response response = requestType("PUT", EndPoints.UPDATEADDRESS);
//		String body = getBodyAsPrettyString(response3);
//		System.out.println(body);
		
		UpdateAddress_Output_Pojo updateAddressOut = response.as(UpdateAddress_Output_Pojo.class);
		String message = updateAddressOut.getMessage();
		System.out.println(message);
		
	}
	
	
	@Test(priority=4)
	/**
	 * @CreationDate 26/06/2022
	 * @Description To get the address
	 */
	public void getAddress() {
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type","application/json");
		Header h2 = new Header("Authorization","Bearer " +logtoken);
		h.add(h1); h.add(h2);
		
		Headers headers = new Headers(h);
		addHeaders(headers);
		
		Response response = requestType("GET", EndPoints.GETADDRESS);
	//	String bodyAsPrettyString = getBodyAsPrettyString(response);
	//	System.out.println(bodyAsPrettyString);
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200,"Verify");
		
		GetAddress_Output_Pojo getAddress = response.as(GetAddress_Output_Pojo.class);
		String message = getAddress.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "OK","Verify");
	}
	
	@Test(priority=5)
	/**
	 * @CreationDate 26/06/2022
	 * @Description To delete the address
	 */
	public void deleteAddress() {
		
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type","application/json");
		Header h2 = new Header("Authorization","Bearer " +logtoken);
		h.add(h1); h.add(h2);
		
		Headers headers = new Headers(h);
		addHeaders(headers);
		
		addBody(Payload.deleteAddress(address_id));
		
		Response response = requestType("DELETE", EndPoints.DELETEADDRESS);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
//		String bodyAsPrettyString = getBodyAsPrettyString(response);
//		System.out.println(bodyAsPrettyString);
		
		DeleteAddress_Output_Pojo deleteAddressOutput= response.as(DeleteAddress_Output_Pojo.class);
		String message = deleteAddressOutput.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address deleted successfully","Verify");	
		
	}
	
	@Test(priority=6)
	/**
	 * @CreationDate 26/06/2022
	 * @Description To change the profile picture
	 */
	public void changeProfilePic() {
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type","multipart/form-data");
		Header h2 = new Header("Authorization","Bearer " +logtoken);
		h.add(h1); h.add(h2);
		
		Headers headers = new Headers(h);
		addHeaders(headers);
		
		multiPart();
		
		Response response = requestType("POST", EndPoints.UPDATEPROFILEPIC);
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200,"Verify Status Code");
		
	//	System.out.println(getBodyAsPrettyString(response));
		
		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);
		String message = changeProfilePic_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Profile updated Successfully", "Verify Profile updated Successfully");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
