package com.amazonweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazonweb.dao.IShoppingCartDAO;
import com.amazonweb.model.ShoppingCart;
import com.amazonweb.service.IShoppingCartService;

@Service
public class ShoppingCartService implements IShoppingCartService {
	@Autowired
	private IShoppingCartDAO shoppingCartDAO;

	@Override
	public Long createShoppingCart(ShoppingCart shoppingCart) {
		Long id = shoppingCartDAO.createShoppingCart(shoppingCart);
		if (id == null) {
			return null;
		} else {
			return id;
		}
	}

	@Override
	public Long findShoppingCartByStatusIdAndUserId(Integer userId) {
		Long id = shoppingCartDAO.findShoppingCartByStatusIdAndUserId(userId);
		if (id == null) {
			return null;
		} else {
			return id;
		}
	}
}