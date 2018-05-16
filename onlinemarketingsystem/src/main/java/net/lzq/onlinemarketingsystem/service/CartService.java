package net.lzq.onlinemarketingsystem.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.lzq.marketingbackend.dao.CartLineDAO;
import net.lzq.marketingbackend.dto.Cart;
import net.lzq.marketingbackend.dto.CartLine;
import net.lzq.marketingbackend.dto.Product;
import net.lzq.onlinemarketingsystem.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	//return the cart of user who has logged in
	private Cart getCart(){
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	//return the entire cart line
	public List<CartLine> getCartLines(){
		
		return cartLineDAO.list(this.getCart().getId());
	}

	public String updateCartLine(int cartLineId, int count) {
		
		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null){
			
			return "result=error";
		}else{
			
			Product product = cartLine.getProduct();
			
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity() <= count){
				
				count = product.getQuantity();
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPprice());
			
			cartLine.setTotal(product.getUnitPprice() * count);
			
			cartLineDAO.update(cartLine);
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
		}
		
	}

	public String deleteCartLine(int cartLineId) {
		
		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null){
			return "result=error";
		}else{
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//remove the cart line
			cartLineDAO.delete(cartLine);
			return "result=deleted";
		}
		
	}
}
