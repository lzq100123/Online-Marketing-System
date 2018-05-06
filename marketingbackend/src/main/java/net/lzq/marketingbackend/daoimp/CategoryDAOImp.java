package net.lzq.marketingbackend.daoimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.lzq.marketingbackend.dao.CategoryDAO;
import net.lzq.marketingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImp implements CategoryDAO {

	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		//test for adding category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("cat1.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for mobile!");
		category.setImageURL("cat2.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Computer");
		category.setDescription("This is some description for computer!");
		category.setImageURL("cat3.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
