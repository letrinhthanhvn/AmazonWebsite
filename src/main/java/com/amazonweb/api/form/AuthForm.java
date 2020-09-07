package com.amazonweb.api.form;

import java.io.Serializable;

public class AuthForm  {
    private String username;
    private String token;
    private Integer role;
//    private  String message;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
