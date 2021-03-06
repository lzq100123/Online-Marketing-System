package net.lzq.marketingbackend.dao;

import java.util.List;

import net.lzq.marketingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//busniess methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	List<Product> getProductByParam(String string, int i);
	
}
