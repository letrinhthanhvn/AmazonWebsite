package com.amazonweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonweb.dao.ICatalogDAO;
import com.amazonweb.model.Catalog;
import com.amazonweb.service.ICatalogService;

@Service
public class CatalogService implements ICatalogService {

	@Autowired
	private ICatalogDAO catalogDAO;

	@Override
	public List<Catalog> getAllCatalog() {
		return catalogDAO.getAllCatalog();
	}

}
