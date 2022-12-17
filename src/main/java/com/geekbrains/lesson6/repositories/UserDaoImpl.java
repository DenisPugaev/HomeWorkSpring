package com.geekbrains.lesson6.repositories;

import com.geekbrains.lesson6.models.Products;
import com.geekbrains.lesson6.models.Users;
import org.hibernate.Session;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private final SessionFactoryUtils factory;

    public UserDaoImpl(SessionFactoryUtils factory) {
        this.factory = factory;
    }

    @Override
    public List<Users> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Users> listUsers = session.createQuery("select u from Users u", Users.class).getResultList();
            session.getTransaction().commit();
            return listUsers;
        }
    }

    @Override
    public Users findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Users user = session.get(Users.class, id);
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public Users findByName(String name) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Users user = session.createQuery("select  u from Users u where u.name=:name", Users.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public void save(Users user) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
//                session.saveOrUpdate(product);
            session.merge(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Users u where u.id=:id", Users.class)
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

}


