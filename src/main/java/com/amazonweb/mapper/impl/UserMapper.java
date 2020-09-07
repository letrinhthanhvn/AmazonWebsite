package com.amazonweb.mapper.impl;

import com.amazonweb.mapper.RowMapper;
import com.amazonweb.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getNString("phone"));
            user.setEmail(rs.getString("email"));
            user.setCreated(rs.getInt("created"));
            user.setRole(rs.getInt("role"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error from mapper");
            return null;
        }
    }
}
