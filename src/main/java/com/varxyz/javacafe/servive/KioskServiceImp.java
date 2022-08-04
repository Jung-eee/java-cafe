package com.varxyz.javacafe.servive;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.KioskDao;
import com.varxyz.javacafe.domain.Cart;

public class KioskServiceImp  implements KioskService{
	@Autowired
	KioskDao kioskDao;
	@Override
	public int addCart(Cart cart) {
		return 0;
		
		
	}

}
