package net.lzq.marketingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.lzq.marketingbackend.dao.CartLineDAO;
import net.lzq.marketingbackend.dao.ProductDAO;
import net.lzq.marketingbackend.dao.UserDAO;
import net.lzq.marketingbackend.dto.Cart;
import net.lzq.marketingbackend.dto.CartLine;
import net.lzq.marketingbackend.dto.Product;
import net.lzq.marketingbackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public  static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.lzq.marketingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAddNewCartLine(){
		
		//get user
		user = userDAO.getByEmail("hmy@hawk.iit.edu");
		
		//fetch the cart
		cart = user.getCart();
		
		//get the product
		product = productDAO.get(1);
		
		//create new cart line
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPprice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * cartLine.getBuyingPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartline", true, cartLineDAO.add(cartLine));
		
		//update cart line
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
	}
	
	
}
