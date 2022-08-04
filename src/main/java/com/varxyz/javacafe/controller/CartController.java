package com.varxyz.javacafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.Service;
import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.servive.KioskServiceImp;
import com.varxyz.javacafe.servive.MenuItemServiceImp;
import com.varxyz.javacafe.servive.menuItemService;

@Controller
public class CartController {
	@Autowired
	KioskServiceImp kioskService;
	
	@Autowired
	MenuItem menuItem;
	
	@Autowired
	MenuItemServiceImp menuItemService;
	
	@GetMapping("/kiosk/add_cart")
	public String addCart(HttpServletRequest request, Model model) {
		String imgName = request.getParameter("imgName");
		MenuItem menuItem =  menuItemService.getMenuItemByImgName(imgName);
		
		model.addAttribute("menuItem",menuItem);
				
		return "kiosk/add_cart";
		
	}
}
