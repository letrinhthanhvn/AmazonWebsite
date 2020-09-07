package com.amazonweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonweb.dao.ICatalogChildDAO;
import com.amazonweb.model.CatalogChild;
import com.amazonweb.service.ICatalogChildService;

@Service
public class CatalogChildService implements ICatalogChildService {

	@Autowired
	private ICatalogChildDAO catalogDAO;

	@Override
	public List<CatalogChild> getAll() {
		return catalogDAO.getAll();
	}

	@Override
	public Long addCatalog(CatalogChild catalog) {
		return catalogDAO.addCatalogChild(catalog);
	}

	@Override
	public void updateCatalog(CatalogChild catalog) {
		catalogDAO.updateCatalogChild(catalog);
	}

	@Override
	public void deleteCatalog(int id) {
		// TODO Auto-generated method stubÏ
	}

	@Override
	public CatalogChild findById(int id) {
		return catalogDAO.findById(id);
	}

	@Override
	public Long findByCatalogIdAndName(CatalogChild catalog) {
		return catalogDAO.findByCatalogIdAndName(catalog);
	}
}
