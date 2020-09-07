package com.amazonweb.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonweb.mapper.RowMapper;
import com.amazonweb.model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs) {
		try {
			Product item = new Product();
			item.setId(rs.getLong("id"));
			item.setCatalogId(rs.getInt("catalog_id"));
			item.setName(rs.getString("name"));
			item.setDescription(rs.getString("description"));
			item.setCreated(rs.getInt("created"));
			item.setDiscount(rs.getInt("discount"));
			item.setImageList(rs.getString("image_list"));
			item.setPrice(rs.getDouble("price"));
			item.setQuantity_limit(rs.getInt("qty_buy_limit"));
			item.setQuantity(rs.getInt("quantity"));
			return item;
		} catch (SQLException e) {
			return null;
		}
	}
}
