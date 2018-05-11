package net.lzq.marketingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	
	/**
	 * Private field
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private User user;
	@Column(name = "cart_lines")
	private int cartLines;
	@Column(name = "grand_total")
	private double grandTotal;
	
	/**
	 * toString method for logging and debugging purpose
	 */
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", cartLines=" + cartLines + ", grandTotal=" + grandTotal
				+ "]";
	}
	
	/**
	 * Getters and setters
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
