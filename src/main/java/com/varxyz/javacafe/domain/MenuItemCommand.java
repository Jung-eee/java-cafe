package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemCommand {
	private String bigCategoryName;
	private String menuName;
	private double menuPrice;
}
