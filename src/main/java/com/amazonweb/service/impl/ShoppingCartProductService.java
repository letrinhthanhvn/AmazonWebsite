package com.amazonweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonweb.dao.IShoppingCartProductDAO;
import com.amazonweb.model.ShoppingCartProduct;
import com.amazonweb.service.IShoppingCartProductService;

import java.util.List;

@Service
public class ShoppingCartProductService implements IShoppingCartProductService {
	
	@Autowired
	private IShoppingCartProductDAO dao;

	@Override
	public Long insertShoppingCartProduct(ShoppingCartProduct shoppingProductCart) {
		Long id = dao.insertShoppingCartProduct(shoppingProductCart);
		if (id == null) {
			return null;
		} else {
			return id;
		}
	}

	@Override
	public List<ShoppingCartProduct> getAll(Long id) {
		return dao.getAll(id);
	}

	@Override
	public ShoppingCartProduct getByProductIdAndShoppingCartId(Long productId, Long shoppingCartId) {
		return dao.findByProductIdAndShoppingCartId(productId, shoppingCartId);
	}

	@Override
	public void updateShoppingCartProduct(ShoppingCartProduct shoppingProductCart) {
		dao.updateShoppingCartProduct(shoppingProductCart);
	}

}
