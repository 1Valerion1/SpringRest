package com.example.springapi.springapi.api.dao;

import com.example.springapi.springapi.api.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductsDAOImpl implements ProductsDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Products> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();

        Query<Products> query = session.createQuery("from Products",Products.class);
        List<Products> allProducts = query.getResultList();
        return allProducts;
    }

    @Override
    public Products getProducts(long id) {
        Session session = sessionFactory.getCurrentSession();
        Products products = session.get(Products.class,id);

        return products;
    }

    @Override
    public Products getAllProductsCategory(String category){
        Session session = sessionFactory.getCurrentSession();
        Query<Products> query = session.createQuery("from Products",Products.class);

        Products products = session.get(Products.class,category);

        return products;
    }

    @Override
    public void saveProducts(Products products) {
        Session session = sessionFactory.getCurrentSession();
         session.persist(products);
        //session.saveOrUpdate(products);
    }


    @Override
    public void deleteProducts(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Products> query = session.createNativeQuery("delete from Products where id =:id",Products.class);
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
