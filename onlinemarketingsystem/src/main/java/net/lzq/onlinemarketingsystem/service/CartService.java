package net.lzq.onlinemarketingsystem.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.lzq.marketingbackend.dao.CartLineDAO;
import net.lzq.marketingbackend.dto.Cart;
import net.lzq.marketingbackend.dto.CartLine;
import net.lzq.onlinemarketingsystem.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartlineDAO;
	
	@Autowired
	private HttpSession session;
	
	//return the cart of user who has logged in
	private Cart getCart(){
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	//return the entire cart line
	public List<CartLine> getCartLines(){
		
		return cartlineDAO.list(this.getCart().getId());
	}
}
