package net.lzq.marketingbackend.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.lzq.marketingbackend.dao.CartLineDAO;
import net.lzq.marketingbackend.dto.Cart;
import net.lzq.marketingbackend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImp implements CartLineDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public CartLine get(int id) {
		
		return sessionFactory.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean add(CartLine cartline) {
		
		try {
			sessionFactory.getCurrentSession().persist(cartline);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartline) {
		
		try {
			sessionFactory.getCurrentSession().update(cartline);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(CartLine cartline) {
		
		try {
			sessionFactory.getCurrentSession().delete(cartline);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CartLine> list(int cartId) {

		String query = "FROM CartLine WHERE cartId = :cartId";
		
		return sessionFactory.
				getCurrentSession().
				 createQuery(query, CartLine.class).
				  setParameter("cartId", cartId).
				   getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";

		return sessionFactory.
				getCurrentSession().
				 createQuery(query, CartLine.class).
				  setParameter("cartId", cartId).
				  setParameter("available", true).
				   getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {

		
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		
		try {
			return sessionFactory.
					getCurrentSession().
					 createQuery(query, CartLine.class).
					  setParameter("cartId", cartId).
					  setParameter("productId", productId).
					   getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	//related to the cart
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	
	
}
