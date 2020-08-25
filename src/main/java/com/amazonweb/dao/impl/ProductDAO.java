package com.amazonweb.dao.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.amazonweb.dao.IProductDAO;
import com.amazonweb.mapper.impl.ProductMapper;
import com.amazonweb.model.Product;

@Repository
public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {

	@Override
	public List<Product> getAllProduct() {
		String sql = "SELECT * FROM product";
		return query(sql, new ProductMapper());
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}
}