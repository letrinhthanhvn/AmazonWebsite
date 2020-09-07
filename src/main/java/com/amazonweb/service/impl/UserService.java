package com.amazonweb.service.impl;

import com.amazonweb.dao.IUserDAO;
import com.amazonweb.model.User;
import com.amazonweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public Long register(User user) {
        Long id = userDAO.register(user);
        if (id == null) {
            System.out.printf("Service error");
            return null;
        } else {
            return id;
        }
    }

    @Override
    public User findById(Long id) {
        User user = userDAO.findById(id);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }

    @Override
    public User findByUsername(String username) {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password, Integer status) {
        User user = userDAO.findByUsernameAndPassword(username, password, status);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }
}
