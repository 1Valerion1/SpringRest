package com.example.springapi.springapi.service;

import com.example.springapi.springapi.api.dao.ProductsDAO;
import com.example.springapi.springapi.api.model.Products;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
   private ProductsDAO productsDAO;
    @Override
    @Transactional
    public List<Products> getAllProducts() {
        return productsDAO.getAllProducts();
    }

    @Override
    @Transactional
    public void saveProducts(Products products) {
        productsDAO.saveProducts(products);
    }

    @Override
    @Transactional
    public Products getProducts(long id) {
        return productsDAO.getProducts(id);
    }

    //Тут может быть список и надо составить запрос на SQL
    @Override
    @Transactional
    public Products getAllProductsCategory(String category) {
        return productsDAO.getAllProductsCategory(category);
    }

    @Override
    @Transactional
    public void deleteProducts(int id) {
        productsDAO.deleteProducts(id);
    }
}
