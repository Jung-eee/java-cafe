package com.varxyz.javacafe.servive;

import java.util.List;

import com.varxyz.javacafe.controller.CategoryProvider;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.MenuItem;

public interface menuItemService {

	void  addMenuItem(MenuItem menuItem, Image img);
	List<MenuItem> viewAllMenu();
	List<CategoryProvider> getCategoryProvider ();


}
