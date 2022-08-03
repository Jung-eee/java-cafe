package com.varxyz.javacafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.javacafe.controller.CategoryProvider;
import com.varxyz.javacafe.domain.BigCategory;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.MenuItem;

public class MenuItemDao {
private JdbcTemplate jdbcTemplate;
	
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long addMenuItem(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem (bigCategoryFk, bigCategoryName, menuName, menuPrice)"
				+ " VALUES(?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"mId"});
			pstmt.setLong(1, 1001);
			pstmt.setString(2, menuItem.getBigCategoryName().getBigCategoryName());
			pstmt.setString(3, menuItem.getMenuName());
			pstmt.setDouble(4, menuItem.getMenuPrice());
			
			return pstmt;
		};
		jdbcTemplate.update(creator, keyHolder);
		System.out.println("상품등록완료 mid=" + keyHolder.getKey().longValue());
		return keyHolder.getKey().longValue();
		
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
	
	public List<MenuItem> viewAllMenu() {
		String sql = "SELECT m.menuName, m.menuPrice, b.BigCategoryName,"
				+ " i.imgUrl, i.imgName FROM MenuItem m INNER JOIN Image i ON m.mId = i.menuFk"
				+ " INNER JOIN BigCategory b ON b.bid = m.bigCategoryFk";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem(rs.getString("menuName"), rs.getInt("menuPrice")
						, new BigCategory(rs.getString("BigCategoryName")),
								new Image(rs.getString("imgUrl"), rs.getString("imgName")));
				return menuItem;
			}
			
		});
	}
	
	public String  viewImg(String  MenuName) {
		String sql = "SELECT i.imgName FROM Image i INNER JOIN MenuItem m ON i.menuFk = m.mId WHERE m.menuName=? ";
		return jdbcTemplate.queryForObject(sql, String.class, MenuName);
		
	}
	
	public List<CategoryProvider> getCategoryProvider ()  {
		String sql = "SELECT * FROM BigCategory";
		return jdbcTemplate.query(sql, new RowMapper<CategoryProvider>() {

			@Override
			public CategoryProvider mapRow(ResultSet rs, int rowNum) throws SQLException {
				CategoryProvider categoryProvider = new CategoryProvider(rs.getLong("bid"), rs.getString("bigCategoryName"));
				return categoryProvider;
			}
			
		});
		
	}

}
