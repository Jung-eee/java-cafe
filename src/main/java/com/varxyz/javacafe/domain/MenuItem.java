package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {
	private long mid;
	private long bigCategoryFk;
	private String bigCategoryName;
	private String menuName;
	private double menuPrice;
	private char ihd; // ice, hot, desert
	private int quantity;
}
