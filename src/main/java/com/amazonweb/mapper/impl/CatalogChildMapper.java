package com.amazonweb.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonweb.mapper.RowMapper;
import com.amazonweb.model.CatalogChild;

public class CatalogChildMapper implements RowMapper<CatalogChild> {

//	@Override
//	public CatalogChild mapRow(ResultSet rs, int rowNum) throws SQLException {
//		// TODO Auto-generated method stub
//		CatalogChild catalog = new CatalogChild();
//		catalog.setId(rs.getInt("id"));
//		catalog.setName(rs.getString("name"));
//		catalog.setCatalogParentId(rs.getInt("catalog_parent_id"));
//		catalog.setLastUpdate(rs.getInt("last_update"));
//		return catalog;
//	}

	@Override
	public CatalogChild mapRow(ResultSet rs) {
		CatalogChild catalog = new CatalogChild();
		try {
			catalog.setId(rs.getInt("id"));
			catalog.setName(rs.getString("name"));
			catalog.setCatalogParentId(rs.getInt("catalog_parent_id"));
			catalog.setLastUpdate(rs.getInt("last_update"));
			return catalog;
		} catch (SQLException e) {
			return null;
		}
	}
}
