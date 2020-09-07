package com.amazonweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazonweb.dao.ICatalogParentDAO;
import com.amazonweb.mapper.impl.CatalogParentMapper;
import com.amazonweb.model.CatalogParent;

@Repository
public class CatalogParentDAO extends AbstractDAO<CatalogParent> implements ICatalogParentDAO {

	@Override
	public List<CatalogParent> getAllCatalog() {
		String sql = "SELECT * FROM catalog_parent";
		return query(sql, new CatalogParentMapper());
	}

	@Override
	public void addCatalog(CatalogParent catalog) {
		String sql = "INSERT INTO catalog_parent (`name`, `icon_name`) VALUES (?, ?)";
		update(sql, catalog.getName(), catalog.getIconName());
	}

	@Override
	public void updateCatalog(CatalogParent catalog) {
		String sql = "UPDATE catalog_parent SET name = ?, icon_name = ? WHERE id = ?";
		update(sql, catalog.getName(), catalog.getIconName(), catalog.getId());
	}

	@Override
	public void deleteCatalog(CatalogParent catalog) {
		String sql = "DELETE FROM catalog_parent WHERE id = ?";
		update(sql, catalog.getId());
	}

	@Override
	public CatalogParent findById(int id) {
		String sql = "SELECT * FROM catalog_parent WHERE id = ?";
		List<CatalogParent> items = query(sql, new CatalogParentMapper(), id);
		if (items.isEmpty()) {
			return null;
		} else {
			return items.get(0);
		}
	}

}
