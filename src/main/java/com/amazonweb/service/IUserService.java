package com.amazonweb.service;

import com.amazonweb.model.Product;
import com.amazonweb.model.User;

import java.util.List;

public interface IUserService {
	Long register(User user);

	User findById(Long id);

	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password, Integer status);
}