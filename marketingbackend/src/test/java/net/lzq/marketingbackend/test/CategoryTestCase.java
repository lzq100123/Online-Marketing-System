package net.lzq.marketingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.lzq.marketingbackend.dao.CategoryDAO;
import net.lzq.marketingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.lzq.marketingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
//	@Test
//	public void testAddCategory(){
//		
//		category = new Category();
//		category.setName("Laptop");
//		category.setDescription("This is some description for laptop!");
//		category.setImageURL("cat2.png");
//		
//		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
//		
//	}
	
//	@Test
//	public void testGetCategory(){
//		
//		category = categoryDAO.get(1);
//		
//		assertEquals("Successfully fetched a single category from the table!", "Television", category.getName());
//		
//	}
	
//	@Test
//	public void testUpdateCategory(){
//		
//		category = categoryDAO.get(1);
//		
//		category.setName("TV");
//		
//		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));
//		
//	}
	
//	@Test
//	public void testDeleteCategory(){
//		
//		category = categoryDAO.get(1);
//		
//		category.setName("TV");
//		
//		assertEquals("Successfully delete a single category in the table!", true, categoryDAO.delete(category));
//		
//	}
	
//	@Test
//	public void testListCategory(){
//		
//		
//		assertEquals("Successfully fetched a list of category from the table!", 1, categoryDAO.list().size());
//		
//	}
	
	@Test
	public void testCRUDCategory(){
		
		//add operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("cat3.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for Television!");
		category.setImageURL("cat4.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
	
		//update operation
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));
		
		//delete the category
		assertEquals("Successfully delete a single category in the table!", true, categoryDAO.delete(category));
		
		//fetching a list of category
		assertEquals("Successfully fetched a list of category from the table!", 1, categoryDAO.list().size());
		
	}
	
}
