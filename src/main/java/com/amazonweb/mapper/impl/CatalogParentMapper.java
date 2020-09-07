package com.amazonweb.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonweb.mapper.RowMapper;
import com.amazonweb.model.CatalogChild;
import com.amazonweb.model.CatalogParent;

public class CatalogParentMapper implements RowMapper<CatalogParent> {

	@Override
	public CatalogParent mapRow(ResultSet rs) {
		try {
			CatalogParent item = new CatalogParent();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setIconName(rs.getString("icon_name"));
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

}
