package com.amazonweb.dao;

import java.util.List;

import com.amazonweb.model.CatalogChild;
import com.amazonweb.model.CatalogParent;
import com.amazonweb.model.Product;

public interface ICatalogParentDAO extends IGenericDAO<CatalogParent> {
	List<CatalogParent> getAllCatalog();

	void addCatalog(CatalogParent catalog);

	void updateCatalog(CatalogParent catalog);

	void deleteCatalog(CatalogParent catalog);

	CatalogParent findById(int id);
}
