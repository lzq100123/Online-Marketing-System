package net.lzq.onlinemarketingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.lzq.marketingbackend.dao.CategoryDAO;
import net.lzq.marketingbackend.dao.ProductDAO;
import net.lzq.marketingbackend.dto.Category;
import net.lzq.marketingbackend.dto.Product;
import net.lzq.onlinemarketingsystem.util.FileUploadUtility;
import net.lzq.onlinemarketingsystem.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value = "/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation){
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		Product nProduct = new Product();
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		if(operation != null){
			if(operation.equals("product")){
				mv.addObject("message","Product Submitted Successfully!");
			}else if(operation.equals("category")){
				mv.addObject("message","Category Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showEditProducts(@PathVariable int id){
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		//fetch product from database
		Product nProduct = productDAO.get(id);
		//set the product fetch from database
		mv.addObject("product",nProduct);
		
		return mv;
	} 
	
	//handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request){
		if(mProduct.getId() == 0){
			new ProductValidator().validate(mProduct, results);
		}else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}
		//check if there are any errors
		if(results.hasErrors()){

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","Validation Failed for Product Submission!");
			return "page";
		}
		
		logger.info(mProduct.toString());
		/**
		 * update product if it exists in database
		 * else add new product
		 */
		if(mProduct.getId() == 0){
			productDAO.add(mProduct);
		}else{
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		
		//activating and de-activating based on the value of active field
		product.setActive(!product.isActive());
		//updating product in database
		productDAO.update(product);
		
		return (isActive) ? "You have deactived product successfully with id " + product.getId() :
							"You have actived product successfully with id " + product.getId();
		
	}
	
	//handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category){
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}
	
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
}
