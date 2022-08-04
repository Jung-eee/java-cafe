package com.varxyz.javacafe.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	private long cid;
	private String menuName;
	private int menuPrice;
	private int quantity;
	private String imgName;
		
	
}
