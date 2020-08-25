package com.amazonweb.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonweb.mapper.RowMapper;
import com.amazonweb.model.Catalog;

public class CatalogMapper implements RowMapper<Catalog> {

	@Override
	public Catalog mapRow(ResultSet rs) {
		try {
			Catalog item = new Catalog();
			item.setId(rs.getLong("id"));
			item.setName(rs.getString("name"));
			item.setParentId(rs.getLong("parent_id"));
			item.setSortOrder(rs.getInt("sort_order"));
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

}
