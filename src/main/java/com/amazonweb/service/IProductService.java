package com.amazonweb.service;

import java.util.List;

import com.amazonweb.model.Product;

public interface IProductService {
	List<Product> getAllProduct();

	Product addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Product product);

	List<Product> newList();

	Product findById(Long id);
}
