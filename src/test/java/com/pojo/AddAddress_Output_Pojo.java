package com.pojo;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To create pojo class for AddAddress response body
 *
 */
public class AddAddress_Output_Pojo {
	
	private int status;
    private String message;
    private int address_id;
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
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
    
    

}