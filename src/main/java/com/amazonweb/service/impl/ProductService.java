package com.amazonweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonweb.dao.IProductDAO;
import com.amazonweb.mapper.impl.ProductMapper;
import com.amazonweb.model.Product;
import com.amazonweb.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	public List<Product> getAllProduct() {
		System.out.println("IProductService" + productDAO.getAllProduct().size());
		return productDAO.getAllProduct();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> newList() {
		List<Product> list = productDAO.getAllProduct();
		List<Product> result = new ArrayList<>();
		int length = list.size();
		for (int i = 0; i < 3; i++) {
			result.add(list.get(length - 1 - i));
		}
		return result;
	}

	@Override
	public Product findById(Long id) {
		if (productDAO.findById(id) == null) {
			return null;
		} else {
			return productDAO.findById(id);
		}
	}

}