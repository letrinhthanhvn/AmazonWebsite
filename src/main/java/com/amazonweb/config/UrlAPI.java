package com.amazonweb.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UrlAPI {

    private List<String> listUrlAdmin;
    private List<String> listUrlUser;
    private List<String> listUrlGuest;


    public UrlAPI() {
        this.listUrlAdmin = new ArrayList<>(Arrays.asList(
                "/catalogChild/get-all",
                "/admin/catalogChild/create",
                "/admin/catalogChild/update/{id}",
                "/admin/catalogParent/create",
                "/admin/catalogParent/update/{id}",
                "/login",
                "/admin/products/create",
                "/admin/products/update/{id}"
        ));
        this.listUrlUser = new ArrayList<>(Arrays.asList(
                "/catalogChild/get-all",
                "/catalogParent/get-all",
                "/login",
                "/products/get-product/{id}",
                "/users/shoppingCart/create",
                "/users/shoppingCartProduct/create",
                "/users/allShoppingCartProduct/get-all"
        ));
        this.listUrlGuest = new ArrayList<>(Arrays.asList(
                "/catalogChild/get-all",
                "/catalogParent/get-all",
                "/products/get-product/{id}"
        ));
    }

    public List<String> getListUrlAdmin() {
        return listUrlAdmin;
    }

    public List<String> getListUrlUser() {
        return listUrlUser;
    }

    public List<String> getListUrlGuest() {
        return listUrlGuest;
    }
}
