package net.lzq.marketingbackend.dao;

import java.util.List;

import net.lzq.marketingbackend.dto.Address;
import net.lzq.marketingbackend.dto.Cart;
import net.lzq.marketingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean addAddress(Address address);
	User getByEmail(String email);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	
}
