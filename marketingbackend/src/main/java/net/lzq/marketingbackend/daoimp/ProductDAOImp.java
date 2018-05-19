package net.lzq.marketingbackend.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.lzq.marketingbackend.dao.ProductDAO;
import net.lzq.marketingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImp implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	// retrieve a product
	@Override
	public Product get(int productId) {

		try {
			return sessionFactory
						.getCurrentSession()
							.get(Product.class,Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// list a list of products
	@Override
	public List<Product> list() {
		return sessionFactory
					.getCurrentSession()
						.createQuery("FROM Product", Product.class)
							.getResultList();
	}

	// add product
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE isActive = :active";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProducts,Product.class)
							.setParameter("active", true)
								.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE isActive = :active and categoryId = :categoryId";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProductsByCategory,Product.class)
							.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String selectLatestActiveProducts = "FROM Product WHERE isActive = :active ORDER BY id";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectLatestActiveProducts,Product.class)
							.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

	@Override
	public List<Product> getProductByParam(String param, int count) {
		
		String query = "FROM Product WHERE isActive = true ORDER BY " + param + " DESC";
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(query)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
