package com.varxyz.javacafe.servive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.KioskDao;
import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.MenuItem;

public class KioskServiceImp  implements KioskService{
	@Autowired
	KioskDao kioskDao;
	
	/*
	 * 1: 성공 (새 상품)
	 * 2: 샐패 (새 상품 실패)
	 * 3: 실패 (기존상품 실패)
	 * 4: 성공 (기존상품 수량 증가)*/
	@Override
	public int addCart(Cart cart) {
		
		if (chCart(cart) != null ) {
			return upCart(cart);
		}
		return kioskDao.addCart(cart);	
	}
	
	public MenuItem getMenuItemBymenuName(String imgName) {
		return kioskDao.getMenuItemBymenuName(imgName);
	}

	@Override
	public Cart chCart(Cart cart) {
		return kioskDao.chCart(cart);
	}

	@Override
	public int upCart(Cart cart) {
		return kioskDao.upCart(cart);
	}

	@Override
	public List<Cart> getCart() {
		return kioskDao.getCart();
	}

	@Override
	public int pay(Cart cart) {
		return kioskDao.pay(cart);
		
	}

}
