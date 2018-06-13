package net.lzq.marketingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.lzq.marketingbackend.dao.ChatroomDAO;
import net.lzq.marketingbackend.dto.Chatroom;



public class ChatroomTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ChatroomDAO chatroomDAO;
	private Chatroom chatroom;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.lzq.marketingbackend");
		context.refresh();
		chatroomDAO = (ChatroomDAO) context.getBean("chatroomDAO");
	}
	
//	@Test
//	public void testCRUDChatroom(){
//		
//		//create operation
//		chatroom = new Chatroom();
//		chatroom.setName("Hello Kitty");
//		chatroom.setType("anime");
//		chatroom.setDescription("This is some description for Hello Kitty group.");
//		chatroom.setActive(true);
//		
//		assertEquals("Something went wrong when inserting a new chatroom.", true, chatroomDAO.add(chatroom));
//		}
		//getting and updating the category
//		chatroom = chatroomDAO.get(3);
//		chatroom.setName("I fan");
//		assertEquals("Something went wrong when getting and updating a chatroom.", true,chatroomDAO.update(chatroom));
//		assertEquals("Something went wrong when deleting a chatroom.", true,chatroomDAO.delete(chatroom));
//		
//		//getting list of products
//		assertEquals("Something went wrong when getting a list of products.", 4, chatroomDAO.list().size());
//		
//		
//	}
	
	@Test
	public void testListActiveProducts(){
		assertEquals("Something went wrong when getting a list of active chatrooms.", 3, chatroomDAO.listActiveChatrooms().size());
	}

	
	@Test
	public void getLatestActiveProducts(){
		assertEquals("Something went wrong when getting a list of active chatrooms.", 2, chatroomDAO.getLatestActiveChatrooms(2).size());
	}
	
}
