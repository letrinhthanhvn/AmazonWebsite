package com.amazonweb.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonweb.mapper.RowMapper;
import com.amazonweb.model.ShoppingCart;

public class ShoppingCartMapper implements RowMapper<ShoppingCart> {

	@Override
	public ShoppingCart mapRow(ResultSet rs) {
		try {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setId(rs.getLong("id"));
			shoppingCart.setUserId(rs.getInt("user_id"));
			shoppingCart.setLastUpdate(rs.getInt("last_update"));
			shoppingCart.setTotalPrice(rs.getInt("total_price"));
			shoppingCart.setShippingInfo(rs.getString("shipping_info"));
			shoppingCart.setStatusId(rs.getInt("status_id"));
			return shoppingCart;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error from mapper");
			return null;
		}
	}
	
}
