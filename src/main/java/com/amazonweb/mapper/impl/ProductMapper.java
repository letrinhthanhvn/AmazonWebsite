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
			item.setUserId(rs.getLong("userId"));
			item.setName(rs.getString("name"));
			item.setContent(rs.getNString("content"));
			item.setCreated(rs.getInt("created"));
			item.setDiscount(rs.getInt("discount"));
			item.setImageLink(rs.getString("image_link"));
			item.setImageList(rs.getString("image_list"));
			item.setPrice(rs.getInt("price"));
			item.setView(rs.getInt("view"));
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

}
