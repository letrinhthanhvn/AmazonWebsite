package com.amazonweb.dao.impl;

import com.amazonweb.mapper.impl.ShoppingCartMapper;
import org.springframework.stereotype.Repository;

import com.amazonweb.dao.IShoppingCartDAO;
import com.amazonweb.model.ShoppingCart;

import java.util.List;

@Repository
public class ShoppingCartDAO extends AbstractDAO<ShoppingCart> implements IShoppingCartDAO {

	@Override
	public Long createShoppingCart(ShoppingCart shoppingCart) {
		System.out.println("ShoppingCart " + shoppingCart.getUserId() + shoppingCart.getStatusId() + shoppingCart.getShippingInfo());
		String sql = "INSERT INTO shopping_cart (`user_id`, `last_update`, `total_price`, `status_id`, `shipping_info`) VALUES (?, ? ,? , ?, ?)";
		Long id = insert(sql, shoppingCart.getUserId(), shoppingCart.getLastUpdate(), shoppingCart.getTotalPrice(), shoppingCart.getStatusId(), shoppingCart.getShippingInfo());
		if (id == null) {
			return null;
		} else {
			return id;
		}
	}

	@Override
	public Long findShoppingCartByStatusIdAndUserId(Integer userId) {
		String sql = "SELECT * FROM shopping_cart WHERE status_id = 2 AND user_id = ?";
		List<ShoppingCart> results = query(sql, new ShoppingCartMapper(), userId);
		if (results.isEmpty()) {
			return null;
		} else {
			return results.get(0).getId();
		}
	}
}
