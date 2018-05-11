package net.lzq.marketingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.lzq.marketingbackend.dao.UserDAO;
import net.lzq.marketingbackend.dto.Address;
import net.lzq.marketingbackend.dto.Cart;
import net.lzq.marketingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.lzq.marketingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void addTest(){
//		
//		user = new User();
//		user.setFirstName("Jiangyu");
//		user.setLastName("Ding");
//		user.setContactNumber("9999999999");
//		user.setEmail("jyd@hawk.iit.edu");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		// add new user
//		assertEquals("Failed to add new user into database", true, userDAO.addUser(user));
//		
//		// add billing address for this user
//		address = new Address();
//		address.setAddressLineOne("3037 S");
//		address.setAddressLineTwo("Lock Street");
//		address.setCity("Chicago");
//		address.setCountry("USA");
//		address.setPostalCode("60608");
//		address.setState("IL");
//		address.setBilling(true);
//		
//		// link user to address by userid
//		address.setUserId(user.getId());
//		
//		// add address
//		assertEquals("Failed to add billing address", true, userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")){
//			
//			//create cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			// add cart
//			assertEquals("Failed to add cart", true, userDAO.addCart(cart));
//			// add a shipping address for this user
//			
//			address = new Address();
//			address.setAddressLineOne("3087 S");
//			address.setAddressLineTwo("Amazon Street");
//			address.setCity("Seattle");
//			address.setCountry("USA");
//			address.setPostalCode("87105");
//			address.setState("WA");
//			address.setShipping(true);
//			
//			// link user to address by userid
//			address.setUserId(user.getId());
//			
//			//add address
//			assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));
//		}
//	}
	
//	@Test
//	public void addTest(){
//		
//		user = new User();
//		user.setFirstName("Jiangyu");
//		user.setLastName("Ding");
//		user.setContactNumber("9999999999");
//		user.setEmail("jyd@hawk.iit.edu");
//		user.setRole("USER");
//		user.setPassword("123456");
//
//		
//		if(user.getRole().equals("USER")){
//			
//			//create cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			user.setCart(cart);
//		}
//		assertEquals("Failed to add new user", true, userDAO.addUser(user));
//	}
//	
//	@Test
//	public void testUpdateCart(){
//		
//		//fetch the user by the email
//		user = userDAO.getByEmail("jyd@hawk.iit.edu");
//		
//		//get the cart of the user
//		cart = user.getCart();
//		
//		cart.setGrandTotal(55555);
//		cart.setCartLines(2);
//		
//		assertEquals("Failed to update the cart", true, userDAO.updateCart(cart));
//	}
	
//	@Test
//	public void testAddAddress(){
//		
//		//add an user
//		user = new User();
//		user.setFirstName("Jiangyu");
//		user.setLastName("Ding");
//		user.setContactNumber("9999999999");
//		user.setEmail("jyd@hawk.iit.edu");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("Failed to add the user", true, userDAO.addUser(user));
//		
//		//add address for user
//		address = new Address();
//		address.setAddressLineOne("3037 S");
//		address.setAddressLineTwo("Lock Street");
//		address.setCity("Chicago");
//		address.setCountry("USA");
//		address.setPostalCode("60608");
//		address.setState("IL");
//		address.setBilling(true);
//		
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add billing address for user", true, userDAO.addAddress(address));
//		
//		//add shipping address for user
//		address = new Address();
//		address.setAddressLineOne("3087 S");
//		address.setAddressLineTwo("Amazon Street");
//		address.setCity("Seattle");
//		address.setCountry("USA");
//		address.setPostalCode("87105");
//		address.setState("WA");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add shipping address for user", true, userDAO.addAddress(address));
//	}
	
	
//	@Test
//	public void testAddAddress(){
//		
//		user = (User) userDAO.getByEmail("jyd@hawk.iit.edu");
//		
//		address = new Address();
//		address.setAddressLineOne("3078 S");
//		address.setAddressLineTwo("Wentworth Ave.");
//		address.setCity("Chicago-South");
//		address.setCountry("USA");
//		address.setPostalCode("60780");
//		address.setState("IL");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		assertEquals("Failed to add shipping address for user", true, userDAO.addAddress(address));
//		
//	}
	
	@Test
	public void testGetAddress(){
		
		user = (User) userDAO.getByEmail("jyd@hawk.iit.edu");
		
		assertEquals("Failed to fetch the list of shipping address and size does not match!", 2, userDAO.listShippingAddress(user).size());
		
		assertEquals("Failed to fetch the billing address and size does not match!", "Chicago", userDAO.getBillingAddress(user).getCity());
		
	}
	
}
