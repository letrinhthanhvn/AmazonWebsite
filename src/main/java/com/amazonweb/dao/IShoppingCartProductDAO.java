package com.amazonweb.dao;

import com.amazonweb.model.ShoppingCartProduct;

import java.util.List;

public interface IShoppingCartProductDAO {
	Long insertShoppingCartProduct(ShoppingCartProduct shoppingCartProduct);

	List<ShoppingCartProduct> getAll(Long id);

	ShoppingCartProduct findByProductIdAndShoppingCartId(Long productId, Long shoppingCartId);

	void updateShoppingCartProduct(ShoppingCartProduct shoppingCartProduct);
}
