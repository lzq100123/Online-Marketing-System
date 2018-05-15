package net.lzq.marketingbackend.dao;

import java.util.List;

import net.lzq.marketingbackend.dto.Cart;
import net.lzq.marketingbackend.dto.CartLine;

public interface CartLineDAO {
	
	//basic methods for cart lines
	public CartLine get(int id);
	public boolean add(CartLine cartline);
	public boolean update(CartLine cartline);
	public boolean delete(CartLine cartline);
	List<CartLine> list(int cartId);
	
	
	//other business method related to cart lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	boolean updateCart(Cart cart);
}
