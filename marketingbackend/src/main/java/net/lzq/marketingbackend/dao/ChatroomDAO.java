package net.lzq.marketingbackend.dao;

import java.util.List;

import net.lzq.marketingbackend.dto.Chatroom;



public interface ChatroomDAO {
	
	Chatroom get(int chatroomId);
	List<Chatroom> list();
	boolean add(Chatroom chatroom);
	boolean update(Chatroom chatroom);
	boolean delete(Chatroom chatroom);
	
	//busniess methods
	List<Chatroom> listActiveChatrooms();
	List<Chatroom> getLatestActiveChatrooms(int count);
	List<Chatroom> getChatroomsByParam(String param, int count);
}
