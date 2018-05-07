package net.lzq.marketingbackend.dao;

import java.util.List;
import net.lzq.marketingbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	List<Category> list();
	Category get(int id);
	
	
}
