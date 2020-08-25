package com.amazonweb.dao;

import java.util.List;

import com.amazonweb.model.Product;

public interface IProductDAO extends IGenericDAO<Product> {
	List<Product> getAllProduct();
	
	Product addProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Product product);
	
	Product findById(Long id);
}
