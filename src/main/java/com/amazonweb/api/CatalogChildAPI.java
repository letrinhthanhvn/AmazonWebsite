package com.amazonweb.api;

import java.util.ArrayList;
import java.util.List;

import com.amazonweb.config.UrlAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonweb.model.CatalogChild;
import com.amazonweb.model.Product;
import com.amazonweb.service.ICatalogChildService;
import com.amazonweb.utils.MessageUtil;

@RestController
public class CatalogChildAPI {

	@Autowired
	private ICatalogChildService service;

	// get all catalog child
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/catalogChild/get-all", method = RequestMethod.GET)
	public ResponseEntity<MessageUtil<CatalogChild>> getAll() {
		MessageUtil<CatalogChild> message = new MessageUtil<>();
		List<CatalogChild> results = service.getAll();
		if (results.isEmpty()) {
			message.setMessage("Catalog child is empty!");
			return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
		} else {
			message.setMessage("Get catalog child is successful");
			message.setData(results);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
	}

	// Add catalog child
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/admin/catalogChild/create", method = RequestMethod.POST)
	public ResponseEntity<MessageUtil<CatalogChild>> addCatalog(@RequestBody CatalogChild catalog) {
		MessageUtil<CatalogChild> message = new MessageUtil<>();
		if (catalog.getCatalogParentId() == null) {
			message.setMessage("Catalog Parent Id must be not null!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else if (catalog.getName() == null) {
			message.setMessage("Name must be not null!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else {
			Long id = service.findByCatalogIdAndName(catalog);
			if (id != null) {
				message.setMessage("Catalog is duplicate!");
				return new ResponseEntity<>(message, HttpStatus.CONFLICT);
			} else {
				Long newId = service.addCatalog(catalog);
				List<CatalogChild> cataloChild = new ArrayList<>();
				cataloChild.add(service.findById(newId.intValue()));
				message.setMessage("Successful");
				message.setData(cataloChild);
				return new ResponseEntity<>(message, HttpStatus.CREATED);
			}
		}
	}

	// Update Catalog child
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/admin/catalogChild/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCatalog(@PathVariable("id") int id, @RequestBody CatalogChild catalog) {
		MessageUtil<CatalogChild> message = new MessageUtil<>();
		CatalogChild catalogCurrent = service.findById(id);
		if (catalogCurrent == null) {
			System.out.println("Can not update item!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			catalogCurrent.setName(catalog.getName());
			catalogCurrent.setCatalogParentId(catalog.getCatalogParentId());
			catalogCurrent.setLastUpdate(catalog.getLastUpdate());
			service.updateCatalog(catalogCurrent);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
