package com.varxyz.javacafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.MenuItem;


public class KioskDao {
private JdbcTemplate jdbcTemplate;
	
	public KioskDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int addCart(Cart cart) {
		try {
			String sql = "INSERT INTO Cart (menuName, menuPrice, quantity, imgName ) "
					+ " VALUES(?, ?, ?, ?)";			
			jdbcTemplate.update(sql, cart.getMenuName(), cart.getMenuPrice(), cart.getQuantity(), cart.getImgName());
			System.out.println("장바구니 담기완료");
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 2;
		}
	}
	public MenuItem getMenuItemBymenuName(String imgName) {
		String sql = "SELECT m.mid, m.bigCategoryFk, m.menuName, m.menuPrice, i.imgUrl, i.imgName FROM MenuItem m"
	            + " INNER JOIN Image i ON m.mId = i.menuFk WHERE i.imgName=?";
	      
	      return jdbcTemplate.queryForObject(sql, new RowMapper<MenuItem>() {
	    	  @Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				 MenuItem menuItem = new MenuItem();
		            menuItem.setMid(rs.getLong("mid"));
		            menuItem.setBigCategoryFk(rs.getLong("bigCategoryFk"));
		            menuItem.setMenuName(rs.getString("menuName"));
		            menuItem.setMenuPrice(rs.getInt("menuPrice"));
		            menuItem.setImage(new Image(rs.getString("imgUrl"), rs.getString("imgName")));
		            return menuItem;
			}
	         
	      }, imgName);
	}
	public Cart chCart(Cart cart) {
		try {
			String sql = "SELECT * FROM Cart WHERE menuName=? ";
			return jdbcTemplate.queryForObject(sql, new RowMapper<Cart>() {
		    	  @Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		    		  Cart cart = new Cart();
		    		  cart.setCid(rs.getLong("cid"));
		    		  cart.setMenuName(rs.getString("menuName"));
		    		  cart.setMenuPrice(rs.getInt("menuPrice"));
		    		  cart.setQuantity(rs.getInt("quantity"));
		    		  cart.setImgName(rs.getString("imgName"));
			            return cart;
				}
		         
		      }, cart.getMenuName());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return null;
			
		}
		
	}
	public int upCart(Cart cart) {
		String sql = "UPDATE Cart SET quantity = quantity + ? WHERE menuName =? ";
		try {
			jdbcTemplate.update(sql, cart.getQuantity(), cart.getMenuName());
			return 4;
		} catch (Exception e) {
			System.out.println(e);
			return 3;			
		}
	}
	public List<Cart> getCart() {
		try {
			String sql = "SELECT * FROM Cart";
			return jdbcTemplate.query(sql, new RowMapper<Cart>() {
				
		    	  @Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		    		  Cart cart = new Cart();
		    		  cart.setCid(rs.getLong("cid"));
		    		  cart.setMenuName(rs.getString("menuName"));
		    		  cart.setMenuPrice(rs.getInt("menuPrice"));
		    		  cart.setQuantity(rs.getInt("quantity"));
		    		  cart.setImgName(rs.getString("imgName"));
			            return cart;
				}
		         
		      });
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return null;
		}
	}
	public int pay(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}
}
