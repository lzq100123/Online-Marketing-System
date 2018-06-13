package net.lzq.marketingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Chatroom {
	/**
	 *  Private Field
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "please enter the chat room name!")
	private String name;
	@NotBlank(message = "please enter the chat room description!")
	private String description;
	@NotBlank(message = "please enter the type of chat room!")
	private String type;
	@Column(name = "is_active")
	private boolean isActive;
	
	
	
	@Override
	public String toString() {
		return "Chatroom [id=" + id + ",  name=" + name + ", description=" + description + ", type="
				+ type + ", isActive=" + isActive + "]";
	}
	/**
	 * Getter and Setter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
