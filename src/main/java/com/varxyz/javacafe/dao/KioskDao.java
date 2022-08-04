package com.varxyz.javacafe.dao;

import java.sql.PreparedStatement;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.javacafe.domain.Cart;

public class KioskDao {
private JdbcTemplate jdbcTemplate;
	
	public KioskDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int addCart(Cart cart) {
		String sql = "INSERT INTO Cart (menuName, menuPrice, quantity, imgName ) "
				+ " VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, cart.getMenuName(), cart.getMenuPrice(), cart.getQuantity(), cart.getImgName());
		System.out.println("장바구니 담기완료");
		return 1;
	}
}
