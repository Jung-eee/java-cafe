package com.varxyz.javacafe.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.javacafe.domain.BigCategory;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemDao {
private JdbcTemplate jdbcTemplate;
	
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addMenuItem(MenuItem menuItem, Image img) {
		String sql = "INSERT INTO MenuItem (bigCategoryFk, bigCategoryName, menuName, menuPrice)"
				+ " VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, 1001, menuItem.getBigCategoryName(), menuItem.getMenuName(), menuItem.getMenuPrice());
		System.out.println("상품등록 완료");
		
	}
	public void addProductImg(long menuId, Image img) {
		String sql = "INSERT INTO Image (menuFk, imgName, imgOriname, imgUrl)"
				+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, menuId, img.getImgName(), img.getImgOriName(), img.getImgUrl());
		System.out.println("이미지 저장완료");
	}

	public boolean addCategory(BigCategory bigCategory) {
		String sql = "INSERT INTO BigCategory (BigCategoryName) VALUE (?)";
		boolean result = true;
		try {
			jdbcTemplate.update(sql, bigCategory.getBigCategoryName());
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}


}
