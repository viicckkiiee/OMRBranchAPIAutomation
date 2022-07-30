package com.pojo;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To create pojo class for ChangeProfilePic response body
 *
 */
public class ChangeProfilePic_Output_Pojo {
	
	private int status;
    private String message;
    private DataProfile data;
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
	public DataProfile getData() {
		return data;
	}
	public void setData(DataProfile data) {
		this.data = data;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	private int cart_count;

}
