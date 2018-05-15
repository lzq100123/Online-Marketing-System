package net.lzq.marketingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartLine implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	/**
	 * private field
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cart_id")
	private int cartId;
	@OneToOne
	private Product product;
	@Column(name = "product_count")
	private int productCount;
	private double total;
	@Column(name = "buying_price")
	private double buyingPrice;
	@Column(name = "is_available")
	private boolean isAvailable;
	
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
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "CartLine [id=" + id + ", cartId=" + cartId + ", product=" + product + ", productCount=" + productCount
				+ ", total=" + total + ", buyingPrice=" + buyingPrice + ", isAvailable=" + isAvailable + "]";
	}
	
	
	
	
	
}
