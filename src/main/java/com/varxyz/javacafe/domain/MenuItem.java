package com.varxyz.javacafe.domain;

import java.sql.Timestamp;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {
	private long mid;
	private long bigCategoryFk;
	private int menuPrice;
	private String menuName;
	private BigCategory bigCategoryName;
	private Image image;
	private String description;

	public MenuItem() {
		
	}
	
	
	public MenuItem(String menuName, int menuPrice, BigCategory bigCategoryName, Image image) {
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.bigCategoryName = bigCategoryName;
		this.image = image;
	}


	
	
	
}
