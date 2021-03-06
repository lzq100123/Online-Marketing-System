package net.lzq.onlinemarketingsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.lzq.marketingbackend.dao.CategoryDAO;
import net.lzq.marketingbackend.dao.ChatroomDAO;
import net.lzq.marketingbackend.dao.ProductDAO;
import net.lzq.marketingbackend.dto.Category;
import net.lzq.marketingbackend.dto.Chatroom;
import net.lzq.marketingbackend.dto.Product;
import net.lzq.onlinemarketingsystem.exception.ProductNotFoundException;

@Controller
public class PageController {
		
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ChatroomDAO chatroomDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		
		logger.info("Inside PageController index method-INFO");
		logger.debug("Inside PageController index method-DEBUG");
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		// passing the category list
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping("/chatroom")
	public ModelAndView chatroom(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Chat Room");
		mv.addObject("userClickChatroom", true);
		return mv;
	}
	
	/**
	 *  Methods to load all products according to category
	 */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		// passing the category list
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		// passing the category list
		mv.addObject("categories",categoryDAO.list());
		
		//passing a single category
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	//viewing a single product
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		
		//update product view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		
		
		return mv;
	}
	
	//viewing a single chatroom
		@RequestMapping(value = "/show/{id}/chatroom")
		public ModelAndView showSingleChatroom(@PathVariable int id) throws ProductNotFoundException{
			ModelAndView mv = new ModelAndView("page");
			
			Chatroom chatroom = chatroomDAO.get(id);
			if(chatroom == null) throw new ProductNotFoundException();
			
			mv.addObject("title",chatroom.getName());
			mv.addObject("chatroom", chatroom);
			mv.addObject("userClickShowChatroom",true);
			
			
			return mv;
		}
	
	
	/*mapping to flow id*/
	@RequestMapping("/register")
	public ModelAndView register(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout){
		
		ModelAndView mv = new ModelAndView("login");
		
		if(error != null){
			mv.addObject("message", "Invalid Username and Password!");
		}
		
		if(logout != null){
			mv.addObject("logout", "User has been logged out successfully!");
		}
		
		mv.addObject("title", "Login");
		return mv;
	}
	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied(){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Unauthorized Access");
		mv.addObject("errorDescription", "You are not authorized to view this page");
		return mv;
	}
	
	/*Logout*/
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null){
			
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
//	@RequestMapping(value = "/test")
//	public ModelAndView test(@RequestParam(value = "greeting", required = false)String greeting){
//		if(greeting == null){
//			greeting = "hello there";
//		}
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting",greeting);
//		return mv;
//	}
	
	
//	@RequestMapping(value = "/test/{greeting}")
//	public ModelAndView test(@PathVariable("greeting")String greeting){
//		if(greeting == null){
//			greeting = "hello there";
//		}
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting",greeting);
//		return mv;
//	}
}
