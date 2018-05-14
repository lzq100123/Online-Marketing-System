package net.lzq.marketingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_detail")
public class User implements Serializable{
 
	private static final long serialVersionUID = 1L;
	/**
	 * Private field
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotBlank(message="please enter first name")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message="please enter last name")
	private String lastName;
	@NotBlank(message="please enter email address")
	private String email;
	@Column(name = "contact_number")
	@NotBlank(message="please enter contact number")
	private String contactNumber;
	private String role;
	@NotBlank(message="please enter password")
	private String password;
	private boolean enable = true;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
	
	/**
	 * confirm password transient field
	 */
	@Transient
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	/**
	 * toString method for logging and debugging purpose
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enable="
				+ enable + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	
}
