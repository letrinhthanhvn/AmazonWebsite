package com.amazonweb.service;

import com.amazonweb.model.ShoppingCart;

public interface IShoppingCartService {
	Long createShoppingCart(ShoppingCart shoppingCart);

	Long findShoppingCartByStatusIdAndUserId(Integer userId);
}
