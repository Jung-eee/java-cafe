package com.varxyz.javacafe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.Service;
import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.domain.MenuItemSet;

@Controller
public class CartController {
	
	public ModelAndView add(HttpSession session, String MenuName, int quantity) {
		ModelAndView mav = new ModelAndView("cart");
		MenuItem menuItem = service.getMenuItem(MenuName);
		Cart cart = (Cart)session.getAttribute("CART");
		if( cart == null) {
			cart = new Cart();
			session.setAttribute("CART", cart);
		}
		cart.up(new MenuItemSet(menuItem, quantity));
		mav.addObject("cart",cart);
		mav.addObject("message",MenuItem.getMenuName())
		return mav;
	}
}
