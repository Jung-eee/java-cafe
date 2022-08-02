package com.varxyz.javacafe.servive;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.MenuItemDao;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemServiceImp implements menuItemService {
	@Autowired
	MenuItemDao menuItemDao;
	
	@Override
	public void addMenuItem(MenuItem menuItem,Image img) {
		menuItemDao.addMenuItem(menuItem, img);
		
	}

	

	

}
