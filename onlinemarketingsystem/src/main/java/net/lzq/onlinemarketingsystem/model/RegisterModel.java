package net.lzq.onlinemarketingsystem.model;

import java.io.Serializable;

import net.lzq.marketingbackend.dto.Address;
import net.lzq.marketingbackend.dto.User;

public class RegisterModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Private field
	 */
	private User user;
	private Address billing;
	
	/**
	 * 
	 * Getters and Setters
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	
	
}
