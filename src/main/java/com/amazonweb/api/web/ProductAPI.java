package com.amazonweb.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonweb.model.Product;
import com.amazonweb.service.IProductService;

@RestController
public class ProductAPI {

	@Autowired
	private IProductService productService;

	// Muon client nhan duoc response can them cac library maven de bind json ->
	// java va nguoc lai

	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAllProduct() {
		List<Product> products = productService.getAllProduct();
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		Product product = productService.findById(id);
		if (product == null) {
			return null;
		} else {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		Product currentProduct = productService.findById(id);

		if (currentProduct == null) {
			System.out.println("Can not update item!");
		} else {
			currentProduct.setName(product.getName());
			currentProduct.setContent(product.getContent());
			productService.updateProduct(currentProduct);
		}
	}

}
