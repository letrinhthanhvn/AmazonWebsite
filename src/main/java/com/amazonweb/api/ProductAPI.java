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
import org.springframework.web.bind.annotation.RestController;

import com.amazonweb.model.Product;
import com.amazonweb.service.IProductService;
import com.amazonweb.utils.MessageUtil;
import com.amazonweb.utils.ShoppingCart.MessageReponseId;

@RestController
public class ProductAPI {

	@Autowired
	private IProductService productService;

	// Muon client nhan duoc response can them cac library maven de bind json ->
	// java va nguoc lai

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAllProduct() {
		MessageUtil<Product> message = new MessageUtil<>();
		List<Product> products = productService.getAllProduct();
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/admin/products/create", method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		MessageUtil<Product> message = new MessageUtil<>();
		productService.addProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/products/get-product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
		MessageUtil<Product> message = new MessageUtil<>();
		if (id == null) {
			message.setMessage("Id must be not null!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else {
			Product product = productService.findById(id);
			if (product == null) {
				message.setMessage("Product can not be found!");
				return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/admin/products/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		MessageUtil<Product> message = new MessageUtil<>();
		Product currentProduct = productService.findById(id);
		if (currentProduct == null) {
			System.out.println("Can not update item!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			currentProduct.setName(product.getName());
			currentProduct.setDescription(product.getDescription());
			currentProduct.setQuantity(product.getQuantity());
			currentProduct.setQuantity_limit(product.getQuantity_limit());
			currentProduct.setDiscount(product.getDiscount());
			currentProduct.setImageList(product.getImageList());
			currentProduct.setPrice(product.getPrice());
			currentProduct.setCatalogId(product.getCatalogId());
			productService.updateProduct(currentProduct);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/admin/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@RequestBody Product product) {
		MessageUtil<Product> message = new MessageUtil<>();
		return null;
	}

}
