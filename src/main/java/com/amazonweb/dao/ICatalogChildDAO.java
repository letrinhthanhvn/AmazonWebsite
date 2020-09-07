package com.amazonweb.dao;

import java.util.List;

import com.amazonweb.model.CatalogChild;

public interface ICatalogChildDAO {
	List<CatalogChild> getAll();
	
	void updateCatalogChild(CatalogChild catalog);
	
	Long addCatalogChild(CatalogChild catalog);
	
	CatalogChild findById(int id);
	
	void deleteCatalogChild(int id);

	Long findByCatalogIdAndName(CatalogChild catalog);
}
