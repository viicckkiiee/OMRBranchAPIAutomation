package com.pojo;

import java.util.ArrayList;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To create pojo class for GetAddress response body
 *
 */
public class GetAddress_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<Datum> data;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

}
