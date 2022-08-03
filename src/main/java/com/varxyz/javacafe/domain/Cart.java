package com.varxyz.javacafe.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	private List<MenuItemSet> menuItemSetLsit = new ArrayList<>();
	
	public void up(MenuItemSet menuItemSet) {
		for (MenuItemSet is : menuItemSetLsit) {
			if (MenuItemSet.getMenuItem().getMenuName() == is.getMenuItem().getMenuName()){
				is.setQuantity(is.getQuantity() + menuItemSet.getQuantity());;
				return;
				
			}
		}
		menuItemSet.add(menuItemSet);
	}
}
