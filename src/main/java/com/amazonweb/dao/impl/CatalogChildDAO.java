package com.amazonweb.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amazonweb.dao.ICatalogChildDAO;
import com.amazonweb.mapper.impl.CatalogChildMapper;
import com.amazonweb.model.CatalogChild;

@Repository
public class CatalogChildDAO extends AbstractDAO<CatalogChild> implements ICatalogChildDAO {

//	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CatalogChild> getAll() {
		String sql = "SELECT * FROM catalog_child";
		return query(sql, new CatalogChildMapper());
	}

	@Override
	public void updateCatalogChild(CatalogChild catalog) {
		String sql = "UPDATE catalog_child SET name = ?, catalog_parent_id = ?, last_update = ?";
		update(sql, catalog.getName(), catalog.getCatalogParentId(), catalog.getLastUpdate());
	}

	@Override
	public Long addCatalogChild(CatalogChild catalog) {
		String sql = "INSERT INTO catalog_child (`catalog_parent_id`, `name`, `last_update`) VALUES (?, ? ,?)";
		return insert(sql, catalog.getCatalogParentId(), catalog.getName(), catalog.getLastUpdate());
	}

	@Override
	public CatalogChild findById(int id) {
		String sql = "SELECT * FROM catalog_child WHERE id = ?";
		List<CatalogChild> catalog = query(sql, new CatalogChildMapper(), id);
		if (catalog.isEmpty()) {
			return null;
		} else {
			return catalog.get(0);
		}
	}

	@Override
	public void deleteCatalogChild(int id) {
		String sql = "DELETE FROM catalog_child WHERE id = ? ";
		update(sql, id);
	}

	@Override
	public Long findByCatalogIdAndName(CatalogChild catalog) {
		String sql = "SELECT * FROM catalog_child WHERE catalog_parent_id = ? AND name = ?";
		List<CatalogChild> result = query(sql, new CatalogChildMapper(), catalog.getCatalogParentId(), catalog.getName());
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0).getId();
		}
	}

//	@Override
//	public List<CatalogChild> findByCatalogParentId(int id) {
//		String sql = "SELECT * FROM catalog_child WHERE catalog_parent_id = ?";
//		return query(sql, new CatalogChildMapper(), id);
//	}
}
