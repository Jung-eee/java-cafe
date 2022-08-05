package com.varxyz.javacafe.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.domain.MenuItemCommand;
import com.varxyz.javacafe.servive.MenuItemServiceImp;
import com.varxyz.javacafe.servive.menuItemService;

@Controller
public class MainViewController {
	@Autowired
	MenuItemServiceImp menuItemService;
	
	
	

}
