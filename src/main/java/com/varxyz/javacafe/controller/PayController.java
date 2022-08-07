package com.varxyz.javacafe.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.servive.KioskServiceImp;
import com.varxyz.javacafe.servive.MenuItemServiceImp;
import com.varxyz.javacafe.servive.menuItemService;

@Controller
public class PayController {
	@Autowired
	MenuItemServiceImp menuItemService;
	
	@Autowired
	KioskServiceImp kioskService;
	
	@GetMapping("/kiosk/pay")
	public String Pay(HttpServletRequest request, HttpSession session) {
	kioskService.deleteAll();
	
	return "kiosk/pay";
	}
	
	
	@RequestMapping(value = "/kiosk/requestDelete", method = { RequestMethod.POST })
	@ResponseBody
	public boolean getMenuItemForModal(@RequestBody Cart cart,
	      HttpServletRequest request) throws UnsupportedEncodingException{
	   boolean result = kioskService.deleteThis(cart.getImgName()); 
	   System.out.println(result);
	   return result;
    }
}
