package com.amazonweb.dao.impl;

import com.amazonweb.mapper.impl.ShoppingCartProductMapper;
import org.springframework.stereotype.Repository;

import com.amazonweb.dao.IShoppingCartProductDAO;
import com.amazonweb.model.ShoppingCartProduct;

import java.util.List;

@Repository
public class ShoppingCartProductDAO extends AbstractDAO<ShoppingCartProduct> implements IShoppingCartProductDAO {

    @Override
    public Long insertShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
        String sql = "INSERT INTO shopping_cart_product (`shopping_cart_id`, `product_id`, `quantity`, `discount`) VALUES (?, ?, ? ,?)";
        Long id = insert(sql, shoppingCartProduct.getShoppingCartId(), shoppingCartProduct.getProductId(),
                shoppingCartProduct.getQuantity(), shoppingCartProduct.getDiscount());
        if (id == null) {
            System.out.println("id insertShoppingCartProduct DAO null");
            return null;
        } else {
            return id;
        }
    }

    @Override
    public List<ShoppingCartProduct> getAll(Long id) {
        String sql = "SELECT * FROM shopping_cart_product WHERE shopping_cart_id = ?";
        List<ShoppingCartProduct> results = query(sql, new ShoppingCartProductMapper(), id);
        if (results == null) {
            System.out.println("Something wrong happened!");
            return null;
        } else if (results.isEmpty()) {
            return null;
        } else {
            return results;
        }
    }

    @Override
    public ShoppingCartProduct findByProductIdAndShoppingCartId(Long productId, Long shoppingCartId) {
        String sql = "SELECT * FROM shopping_cart_product WHERE product_id = ? AND shopping_cart_id = ?";
        List<ShoppingCartProduct> results = query(sql, new ShoppingCartProductMapper(), productId, shoppingCartId);
        if (results == null) {
            System.out.println("Something wrong happened!");
            return null;
        } else if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }

    @Override
    public void updateShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
        String sql = "UPDATE shopping_cart_product SET quantity = ? WHERE id = ?";
        update(sql, shoppingCartProduct.getQuantity(), shoppingCartProduct.getId());
    }
}
