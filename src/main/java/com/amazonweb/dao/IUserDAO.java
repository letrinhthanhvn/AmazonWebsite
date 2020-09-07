package com.amazonweb.dao;

import com.amazonweb.model.Product;
import com.amazonweb.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO extends IGenericDAO<User> {
	Long register(User user);

	User findById(Long id);

	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password, Integer status);
}
