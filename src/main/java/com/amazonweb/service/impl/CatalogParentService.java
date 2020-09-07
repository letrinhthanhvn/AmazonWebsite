package com.amazonweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonweb.dao.ICatalogParentDAO;
import com.amazonweb.model.CatalogParent;
import com.amazonweb.service.ICatalogParentService;

@Service
public class CatalogParentService implements ICatalogParentService {

	@Autowired
	private ICatalogParentDAO catalogDAO;

	@Override
	public List<CatalogParent> getAllCatalog() {
		return catalogDAO.getAllCatalog();
	}

	@Override
	public void addCatalog(CatalogParent catalog) {
		catalogDAO.addCatalog(catalog);
	}

	@Override
	public void updateCatalog(CatalogParent catalog) {
		catalogDAO.updateCatalog(catalog);

	}

	@Override
	public void deleteCatalog(CatalogParent catalog) {
		catalogDAO.deleteCatalog(catalog);
	}

	@Override
	public CatalogParent findById(int id) {
		return catalogDAO.findById(id);
	}

}
