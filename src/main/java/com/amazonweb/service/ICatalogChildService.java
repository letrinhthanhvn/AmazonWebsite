package com.amazonweb.service;

import java.util.List;

import com.amazonweb.model.CatalogChild;

public interface ICatalogChildService {
	List<CatalogChild> getAll();

	Long addCatalog(CatalogChild catalog);

	void updateCatalog(CatalogChild catalog);

	void deleteCatalog(int id);

	CatalogChild findById(int id);

	Long findByCatalogIdAndName(CatalogChild catalog);
}
