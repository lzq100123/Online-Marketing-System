package net.lzq.marketingbackend.daoimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.lzq.marketingbackend.dao.ChatroomDAO;
import net.lzq.marketingbackend.dto.Chatroom;



@Repository("chatroomDAO")
@Transactional
public class ChatroomDAOImp implements ChatroomDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Chatroom get(int chatroomId) {
		try {
			return sessionFactory
						.getCurrentSession()
							.get(Chatroom.class,Integer.valueOf(chatroomId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Chatroom> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Chatroom", Chatroom.class)
						.getResultList();
	}

	@Override
	public boolean add(Chatroom chatroom) {
		try {
			sessionFactory.getCurrentSession().persist(chatroom);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Chatroom chatroom) {
		try {
			sessionFactory.getCurrentSession().update(chatroom);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Chatroom chatroom) {
		try {
			chatroom.setActive(false);
			sessionFactory.getCurrentSession().update(chatroom);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Chatroom> listActiveChatrooms() {
		String selectActiveProducts = "FROM Chatroom WHERE isActive = :active";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProducts,Chatroom.class)
							.setParameter("active", true)
								.getResultList();
	}

	@Override
	public List<Chatroom> getLatestActiveChatrooms(int count) {
		String selectLatestActiveProducts = "FROM Chatroom WHERE isActive = :active ORDER BY id";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectLatestActiveProducts,Chatroom.class)
							.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

	@Override
	public List<Chatroom> getChatroomsByParam(String param, int count) {
String query = "FROM Chatroom WHERE isActive = true ORDER BY " + param + " DESC";
		
		return sessionFactory
				.getCurrentSession()
					.createQuery(query)
					.setFirstResult(0)
					.setMaxResults(count)
						.getResultList();
	}
	
}
