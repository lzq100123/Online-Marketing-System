package net.lzq.marketingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.lzq.marketingbackend.dao.ProductDAO;
import net.lzq.marketingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.lzq.marketingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
//	@Test
//	public void testCRUDProduct(){
//		
//		//create operation
//		product = new Product();
//		product.setName("Oppo Selfie S3");
//		product.setBrand("Oppo");
//		product.setDescription("This is some description for oppo mobile phone.");
//		product.setUnitPprice(780);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		
//		assertEquals("Something went wrong when inserting a new product.", true, productDAO.add(product));
//		
//		//getting and updating the category
//		product = productDAO.get(2);
//		product.setName("Samsung Galaxy S7");
//		assertEquals("Something went wrong when getting and updating a product.", true,productDAO.update(product));
//		assertEquals("Something went wrong when deleting a product.", true,productDAO.delete(product));
//		
//		//getting list of products
//		assertEquals("Something went wrong when getting a list of products.", 6, productDAO.list().size());
//		
//		
//	}
	
	@Test
	public void testListActiveProducts(){
		assertEquals("Something went wrong when getting a list of active products.", 5, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Something went wrong when getting a list of active products.", 3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong when getting a list of active products.", 2, productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void getLatestActiveProducts(){
		assertEquals("Something went wrong when getting a list of active products.", 5, productDAO.getLatestActiveProducts(5).size());
	}
	
}
