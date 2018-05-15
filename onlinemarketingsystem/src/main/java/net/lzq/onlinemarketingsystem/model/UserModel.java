package net.lzq.onlinemarketingsystem.model;

import java.io.Serializable;

import net.lzq.marketingbackend.dto.Cart;

public class UserModel implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/**
	 * private field
	 */
	private int id;
	private String fullName;
	private String email;
	private String role;
	private Cart cart;
	

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullName=" + fullName + ", email=" + email + ", role=" + role + ", cart="
				+ cart + "]";
	}
	
	/**
	 * 
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
