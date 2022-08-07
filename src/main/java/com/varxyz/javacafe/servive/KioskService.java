package com.varxyz.javacafe.servive;

import java.util.List;

import com.varxyz.javacafe.domain.Cart;

public interface KioskService {
	
	int addCart(Cart cart);
	Cart chCart(Cart cart);
	int upCart(Cart cart);
	List<Cart> getCart();
	int pay(Cart cart);
	boolean deleteThis(String imgName);
	int deleteAll();
	
}
