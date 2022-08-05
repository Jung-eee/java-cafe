package com.varxyz.javacafe.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.domain.MenuItemCommand;
import com.varxyz.javacafe.servive.KioskServiceImp;
import com.varxyz.javacafe.servive.MenuItemServiceImp;

@Controller
public class CartController {
	@Autowired
	KioskServiceImp kioskService;
	
	@Autowired
	MenuItemServiceImp menuItemService;
	
	@GetMapping("/kiosk/main")
	public String viewMenu(HttpServletRequest request) {
		
		List<MenuItem> menuItemList = menuItemService.viewAllMenu(1001);
		request.setAttribute("menuItemList", menuItemList);
		
		List<Cart> cartList = kioskService.getCart();
		if (cartList.size() >= 1) {
			request.setAttribute("cartList", cartList);			
		}
		
		return "kiosk/main";
	}
	
	
//	@GetMapping("/kiosk/add_cart")
//	public String addCart(HttpServletRequest request, Model model) {
//		String imgName = request.getParameter("imgName");
//		MenuItem menuItem =  menuItemService.getMenuItemByImgName(imgName);
//		
//		model.addAttribute("menuItem",menuItem);
//				
//		return "kiosk/add_cart";
//		
//	}
	
	@RequestMapping(value = "/kiosk/requestObject", method = { RequestMethod.POST })
	@ResponseBody
	public List<MenuItem> viewAllMenu(@RequestBody MenuItemCommand menuItemCommand){
		List<MenuItem> list = menuItemService.viewAllMenu(menuItemCommand.getCategoryId());
		return list;
	}
	
	@RequestMapping(value = "/kiosk/requestForModal", method = { RequestMethod.POST })
	@ResponseBody
	public MenuItem getMenuItemForModal(@RequestBody MenuItemCommand menuItemCommand,
	      HttpServletRequest request) throws UnsupportedEncodingException{
		System.out.println(menuItemCommand.getImgName());
	   MenuItem menuItem = kioskService.getMenuItemBymenuName(menuItemCommand.getImgName());
	   return menuItem;
	}
	
	@PostMapping("kiosk/main")
	public String addCart(Cart cart, HttpServletRequest request ) {
		int result = kioskService.addCart(cart);
		System.out.println(result);
		if (result == 1 || result == 4) {
			return "redirect:/kiosk/main";
		}else {
			request.setAttribute("msg", "오류");
			request.setAttribute("url", "main");
			return "alert";
		}
		
	}
	
}
