package com.auth.Authentication.Service.dto;

import java.util.List;
import java.util.UUID;

import com.auth.Authentication.Service.model.Address;


public class UserDetailsDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Object authorityList;
    private List<Address> addressList;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getAuthorityList() {
		return authorityList;
	}
	public void setAuthorityList(Object authorityList) {
		this.authorityList = authorityList;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public UserDetailsDto(UUID id, String firstName, String lastName, String phoneNumber, String email,
			Object authorityList, List<Address> addressList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.authorityList = authorityList;
		this.addressList = addressList;
	}
	public UserDetailsDto() {
		super();
	}
    
    
}
