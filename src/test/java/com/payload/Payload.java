package com.payload;

import com.pojo.AddAddress_Input_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To initialize pojo class input payloads and use them in request body
 *
 */
public class Payload {
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param mobNo
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @return AddAddress_Input_Pojo
	 * @CreationDate 26/06/2022
	 * @Description To create object and initialize AddAddress_Input_Pojo class variables
	 */
	public static AddAddress_Input_Pojo createAddress(String firstName,String lastName,String mobNo,String apartment,int state,int city,int country,String zipCode,String address,String addressType) {
		
		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo(firstName,lastName,mobNo,apartment,state,city,country,zipCode,address,addressType);
		return addAddress_Input_Pojo;
	}

	/**
	 * 
	 * @param address_id
	 * @param firstName
	 * @param lastName
	 * @param mobNo
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @return UpdateAddress_Input_Pojo
	 * @Creationdate 26/06/2022
	 * @Description To create object and initialize UpdateAddress_Input_Pojo class variables
	 */
	public static UpdateAddress_Input_Pojo changeAddress(String address_id,String firstName,String lastName,String mobNo,String apartment,int state,int city,int country,String zipCode,String address,String addressType) {
	
		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(address_id, firstName,lastName,mobNo,apartment,state,city,country,zipCode,address,addressType);
		return updateAddress_Input_Pojo;	
	}
	
	/**
	 * 
	 * @param address_id
	 * @return DeleteAddress_Input_Pojo
	 * @CreationDate 26/06/2022
	 * @Description To create object and initialize DeleteAddress_Input_Pojo class variables
	 */
	public static DeleteAddress_Input_Pojo deleteAddress(String address_id) {
		
		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id);
		return deleteAddress_Input_Pojo;
			
	}

}
