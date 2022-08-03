package com.varxyz.javacafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.servive.MenuItemServiceImp;


@Controller
@RequestMapping("/menuitem/view_menu")
public class ViewMenuController {
	@Autowired
	MenuItemServiceImp menuItemservice;
	
	@GetMapping
	public String viewMenu(HttpServletRequest request) {
		List<MenuItem> list = menuItemservice.viewAllMenu();
		for(MenuItem m : list) {
			String path = m.getImage().getImgUrl() + m.getImage().getImgName();
			m.getImage().setImgUrl(path);
		}
		request.setAttribute("menuList", list);
		return "menuitem/view_menu";
		
	}
}
