package com.amazonweb.dao;

import com.amazonweb.model.ShoppingCart;

public interface IShoppingCartDAO extends IGenericDAO<ShoppingCart> {
	Long createShoppingCart(ShoppingCart shoppingCart);

	Long findShoppingCartByStatusIdAndUserId(Integer userId);
}
