package com.amazonweb.dao;

import java.util.List;

import com.amazonweb.model.Catalog;

public interface ICatalogDAO extends IGenericDAO<Catalog> {
	List<Catalog> getAllCatalog();
}
