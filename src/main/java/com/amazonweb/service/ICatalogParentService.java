package com.amazonweb.service;

import java.util.List;

import com.amazonweb.model.CatalogParent;

public interface ICatalogParentService {
	List<CatalogParent> getAllCatalog();
	
	void addCatalog(CatalogParent catalog);
	
	void updateCatalog(CatalogParent catalog);
	
	void deleteCatalog(CatalogParent catalog);
	
	CatalogParent findById(int id);
}
