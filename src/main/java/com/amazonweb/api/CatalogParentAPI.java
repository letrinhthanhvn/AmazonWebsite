package com.amazonweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonweb.model.CatalogParent;
import com.amazonweb.service.ICatalogParentService;

@RestController
public class CatalogParentAPI {
	
	@Autowired
	private ICatalogParentService service;

	// Find all catalog
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/catalogParent/get-all", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogParent>> getAll() {
		List<CatalogParent> results = service.getAllCatalog();

		if (results.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	// Add catalog parent
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/admin/catalogParent/create", method = RequestMethod.POST)
	public ResponseEntity<Object> addCatalog(@RequestBody CatalogParent catalog) {
		service.addCatalog(catalog);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/admin/catalogParent/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCatalog(@PathVariable("id") int id, @RequestBody CatalogParent catalog) {
		CatalogParent catalogCurrent = service.findById(id);
		if (catalogCurrent == null) {
			System.out.println("Can not update item!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			catalogCurrent.setName(catalog.getName());
			catalogCurrent.setIconName(catalog.getIconName());
			service.updateCatalog(catalogCurrent);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
