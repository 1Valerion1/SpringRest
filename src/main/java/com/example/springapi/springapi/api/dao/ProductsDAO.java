package com.example.springapi.springapi.api.dao;

import com.example.springapi.springapi.api.model.Products;

import java.util.List;

public interface ProductsDAO {
    public List<Products> getAllProducts();
    public void saveProducts(Products products);

    public Products getProducts(long id);

    public Products getAllProductsCategory(String category);

    public void deleteProducts(int id);

}
