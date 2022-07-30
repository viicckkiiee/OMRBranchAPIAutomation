package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To create reusable methods of RestAssured/API related functions
 *
 */
public class BaseClass {
	
	static RequestSpecification reqSpec;
	public static Response response;
	/**
	 * 
	 * @param key
	 * @param value
	 * @CreationDate 25/06/2022
	 * @Description To add header
	 */
	public static void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key,value);
	//	reqSpec = RestAssured.given().header("Content-Type","application/json");
	}
	/**
	 * 
	 * @param headers
	 * @CreationDate 25/06/2022
	 * @Description To add headers
	 */
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}
	/**
	 * @CreationDate 25/06/2022
	 * @Description To add multipart
	 */
	public void multiPart() {
		reqSpec = reqSpec.multiPart("profile_picture",new File("C:\\Users\\Dell\\OneDrive\\Documents\\coding.jpg"));
	}
	/**
	 * 
	 * @param reqBody
	 * @CreationDate 25/06/2022
	 * @Description To add request body
	 */
	public void addBody(Object reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @CreationDate 25/06/2022
	 * @Description To add basic authorization
	 */
	public static void basicAuth(String username,String password) {
		reqSpec = reqSpec.auth().preemptive().basic(username, password);
	}
	/**
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @CreationDate 25/06/2022
	 * @Description To get values from properties file
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	/**
	 * 
	 * @param key
	 * @param value
	 * @CreationDate 25/06/2022
	 * @Description To add query parameters
	 */
	public static void querypara(String key,String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
	/**
	 * 
	 * @param key
	 * @param value
	 * @CreationDate 25/06/2022
	 * @Description To add path parameters
	 */
	public static void pathPara(String key,String value) {
		reqSpec = reqSpec.pathParams(key,value);
	}
	
	public static void addBody(String reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}
	/**
	 * 
	 * @param reqtype
	 * @param endPoint
	 * @return Response
	 * @CreationDate 25/06/2022
	 * @Description To send request type to the endpoint and get response
	 */
	public static Response requestType(String reqtype,String endPoint) {
		
		switch (reqtype) {
		case "GET"    : response = reqSpec.get(endPoint);
			            break;
		case "PUT"    : response = reqSpec.put(endPoint);
                        break;	  
		case "POST"   : response = reqSpec.post(endPoint);
					    break;            
		case "DELETE" : response = reqSpec.delete(endPoint);
                        break;			    
		default:
			break;
		}
		return response;
	}
	/**
	 * 
	 * @param response
	 * @return int
	 * @CreationDate 25/06/2022
	 * @Description To get the status code from response 
	 */
	public static int getStatusCode(Response response) {	
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	/**
	 * 
	 * @param response
	 * @return ResponseBody
	 * @CreationDate 25/06/2022
	 * @Description To get the response body from response
	 */
	@SuppressWarnings("rawtypes")
	public static ResponseBody getBody(Response response) {
		ResponseBody responseBody = response.getBody();
		return responseBody;
	}
	/**
	 * 
	 * @param response
	 * @return String
	 * @CreationDate 25/06/2022
	 * @Description To get the response body as String from response
	 */
	public static String getBodyAsString(Response response) {
		String asString = getBody(response).asString();
		return asString;	
	}
	/**
	 * 
	 * @param response
	 * @return String
	 * @CreationDate 25/06/2022
	 * @Description To get the response body as pretty String from response
	 */
	public static String getBodyAsPrettyString(Response response) {
		String asPrettyString = getBody(response).asPrettyString();
		return asPrettyString;
	}
}

