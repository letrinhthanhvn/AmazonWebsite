package com.amazonweb.dao.impl;

import java.util.List;
import java.util.Optional;
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
//		String sql 
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE product SET catalog_id = ?, name = ?, price = ?, content = ?, discount = ?, image_link = ?, image_list = ?, view = ? where id = ?";
		update(sql, product.getCatalogId(), product.getName(), product.getPrice(), product.getContent(), product.getDiscount(), product.getImageLink(), product.getImageList(), product.getView(), product.getId());
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product findById(Long id) {
		String sql = "SELECT * FROM product where id = ?";
		List<Product> items = query(sql, new ProductMapper(), id);
		if (items.isEmpty()) {
			return null;
		} else {
			return items.get(0);
		}
	}
}