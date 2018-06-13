package net.lzq.onlinemarketingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.lzq.marketingbackend.dao.ChatroomDAO;
import net.lzq.marketingbackend.dao.ProductDAO;
import net.lzq.marketingbackend.dto.Chatroom;
import net.lzq.marketingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JasonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ChatroomDAO chatroomDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin(){
		return productDAO.list();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsByCategory(@PathVariable int id){
		return productDAO.listActiveProductsByCategory(id);
	}
	
	@RequestMapping("/mv/products")
	@ResponseBody
	public List<Product> getMostViewedProducts(){
		return productDAO.getProductByParam("views", 6);
	}
	
	@RequestMapping("/mp/products")
	@ResponseBody
	public List<Product> getMostPurchasedProducts(){
		return productDAO.getProductByParam("purchases", 6);
	}
	
	@RequestMapping("/all/chatrooms")
	@ResponseBody
	public List<Chatroom> getAllChatrooms(){
		return chatroomDAO.listActiveChatrooms();
	}
	
	@RequestMapping("/{id}/chatroom")
	@ResponseBody
	public Chatroom getSingleChatrooms(@PathVariable int id){
		return chatroomDAO.get(id);
	}
	
}	
