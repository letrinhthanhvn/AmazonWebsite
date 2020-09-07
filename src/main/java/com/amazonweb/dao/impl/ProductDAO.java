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
	public void addProduct(Product product) {
		String sql = "INSERT INTO product (`catalog_id`, `name`, `price`, `description`, `discount`, `created`, `quantity`, `qty_buy_limit`, `image_list`) VALUES(?, ?, ?, ?, ? ,? ,? ,? ,?)";
		update(sql, product.getCatalogId(), product.getName(), product.getPrice(), product.getDescription(),
				product.getDiscount(), product.getCreated(), product.getQuantity(), product.getQuantity_limit(),
				product.getImageList());
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE product SET catalog_id = ?, name = ?, price = ?, description = ?, discount = ?, image_list = ?, quantity =?, qty_buy_limit = ? where id = ?";
		update(sql, product.getCatalogId(), product.getName(), product.getPrice(), product.getDescription(),
				product.getDiscount(), product.getImageList(), product.getQuantity(), product.getQuantity_limit(),
				product.getId());
	}

	@Override
	public void deleteProduct(Product product) {

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