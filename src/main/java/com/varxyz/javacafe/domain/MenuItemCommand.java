package com.varxyz.javacafe.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemCommand {
	private String bigCategoryName;
	private String menuName;
	private int menuPrice;
	private long categoryId;
	private MultipartFile files; 
	private String imgName;
	private String description;
}
