package com.varxyz.javacafe.servive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.controller.CategoryProvider;
import com.varxyz.javacafe.dao.MenuItemDao;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemServiceImp implements menuItemService {
	@Autowired
	MenuItemDao menuItemDao;
	
	@Override
	public void addMenuItem(MenuItem menuItem,Image img) {
		long menuItemId = menuItemDao.addMenuItem(menuItem);
		menuItemDao.addProductImg(menuItemId, img);
	}

	@Override
	public List<MenuItem> viewAllMenu() {
		return menuItemDao.viewAllMenu();
	}

	@Override
	public List<CategoryProvider> getCategoryProvider() {
		return menuItemDao.getCategoryProvider();
	}

	public List<MenuItem> viewAllMenu(long categoryId) {
		return menuItemDao.viewAllMenu(categoryId);
	}

	@Override
	public MenuItem getMenuItemByImgName(String imgName) {
		return menuItemDao.getMenuItemByImgName(imgName);
	}

	

	

}
