package com.amazonweb.dao.impl;

import com.amazonweb.dao.IUserDAO;
import com.amazonweb.mapper.impl.UserMapper;
import com.amazonweb.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

    @Override
    public Long register(User user) {
        String sql = "INSERT INTO user (`name`, `username`, `password`, `phone`, `email`, `created`, `role`) VALUES (?, ?, ?, ? ,?, ?, ?)";
        Long id = insert(sql, user.getName(), user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail(), user.getCreated(), user.getRole());
        return id;
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<User> user = query(sql, new UserMapper(), id);
        if (user == null) {
            System.out.printf("user null");
            return null;
        } else if (user.isEmpty()) {
            System.out.printf("user not exist");
            return null;
        } else {
            return user.get(0);
        }
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        List<User> user = query(sql, new UserMapper(), username);
        if (user == null) {
            System.out.printf("user null");
            return null;
        } else if (user.isEmpty()) {
            System.out.printf("user not exist");
            return null;
        } else {
            System.out.printf("user exist");
            return user.get(0);
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password, Integer status) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND status = ?";
        List<User> results = query(sql, new UserMapper(), username, password, status);
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }
}
