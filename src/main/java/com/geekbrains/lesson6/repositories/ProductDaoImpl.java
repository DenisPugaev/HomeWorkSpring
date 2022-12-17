package com.geekbrains.lesson6.repositories;


import com.geekbrains.lesson6.models.Products;
import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final SessionFactoryUtils factory;

    public ProductDaoImpl(SessionFactoryUtils factory) {
        this.factory = factory;
    }

    @Override
    public List<Products> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Products> listProducts = session.createQuery("from Products p", Products.class).getResultList();
            session.getTransaction().commit();
            return listProducts;
        }
    }


    @Override
    public Products findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Products products = session.get(Products.class, id);
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Products findByName(String name) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Products products = session.createQuery("select  p from Products p where p.name=:name", Products.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void save(Products products) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
//                session.saveOrUpdate(product);
            session.merge(products);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Products p where p.id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

}
