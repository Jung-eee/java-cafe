package com.varxyz.javacafe.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {
	private long mid;
	private long bigCategoryFk;
	private double menuPrice;
	private String menuName;
	private BigCategory bigCategoryName;
	private Image image;

	public MenuItem() {
		
	}
	
	
	public MenuItem(String menuName, double menuPrice, BigCategory bigCategoryName, Image image) {
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.bigCategoryName = bigCategoryName;
		this.image = image;
	}
	
	
}
