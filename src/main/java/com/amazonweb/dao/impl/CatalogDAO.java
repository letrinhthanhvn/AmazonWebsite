package com.amazonweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazonweb.dao.ICatalogDAO;
import com.amazonweb.mapper.impl.CatalogMapper;
import com.amazonweb.model.Catalog;

@Repository
public class CatalogDAO extends AbstractDAO<Catalog> implements ICatalogDAO {

	@Override
	public List<Catalog> getAllCatalog() {
		String sql = "SELECT * FROM catalog";
		return query(sql, new CatalogMapper());
	}

}
