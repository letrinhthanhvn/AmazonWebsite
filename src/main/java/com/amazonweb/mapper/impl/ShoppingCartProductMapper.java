package com.amazonweb.mapper.impl;

import com.amazonweb.mapper.RowMapper;
import com.amazonweb.model.ShoppingCart;
import com.amazonweb.model.ShoppingCartProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartProductMapper implements RowMapper<ShoppingCartProduct> {
    @Override
    public ShoppingCartProduct mapRow(ResultSet rs) {
        try {
            ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();
            shoppingCartProduct.setId(rs.getInt("id"));
            shoppingCartProduct.setShoppingCartId(rs.getLong("shopping_cart_id"));
            shoppingCartProduct.setProductId(rs.getLong("product_id"));
            shoppingCartProduct.setQuantity(rs.getInt("quantity"));
            shoppingCartProduct.setDiscount(rs.getInt("discount"));
            return shoppingCartProduct;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error from mapper");
            return null;
        }
    }
}
