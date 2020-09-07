package com.amazonweb.service;

import com.amazonweb.model.ShoppingCartProduct;

import java.util.List;

public interface IShoppingCartProductService {
	Long insertShoppingCartProduct(ShoppingCartProduct shoppingProductCart);

	List<ShoppingCartProduct> getAll(Long id);

	ShoppingCartProduct getByProductIdAndShoppingCartId(Long productId, Long shoppingCartId);

	void updateShoppingCartProduct(ShoppingCartProduct shoppingProductCart);
}
