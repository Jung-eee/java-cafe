package com.varxyz.javacafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.javacafe.servive.KioskServiceImp;
import com.varxyz.javacafe.servive.MenuItemServiceImp;
import com.varxyz.javacafe.servive.menuItemService;

public class PayController {
	@Autowired
	MenuItemServiceImp menuItemService;
	
	@Autowired
	KioskServiceImp kioskService;
	
	@GetMapping("/kiosk/pay")
	public String Pay(HttpServletRequest request) {
	HttpSession session = request.getSession();
	
	return "kiosk/pay";
	}
}
