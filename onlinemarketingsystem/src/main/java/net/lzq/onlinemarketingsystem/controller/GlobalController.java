package net.lzq.onlinemarketingsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.lzq.marketingbackend.dao.UserDAO;
import net.lzq.marketingbackend.dto.User;
import net.lzq.onlinemarketingsystem.model.UserModel;

@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
		
		if(session.getAttribute("userModel") == null){
			
			//add user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getByEmail(authentication.getName());
			if(user != null){
				
				//create a UserModel object to pass the user detail
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				
				if(userModel.getRole().equals("USER")){
					//set the cart only if user is a customer
					userModel.setCart(user.getCart());
				}
				
				//set userModel in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
}
