package net.lzq.marketingbackend.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.lzq.marketingbackend.dao.CategoryDAO;
import net.lzq.marketingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImp implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}
	
	
	/**
	 * Getting a single category according to id
	 */
	@Override
	public Category get(int id) {
		 
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	

	@Override
	public boolean add(Category category) {
		
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Updating a single category
	 */
	@Override
	public boolean update(Category category) {

		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
