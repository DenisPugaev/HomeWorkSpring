package com.geekbrains.lesson6.repositories;

import com.geekbrains.lesson6.models.Users;

import java.util.List;

public interface UserDao {
    List<Users> findAll();

    Users findById(Long id);
    Users findByName(String name);

    void save(Users user);

    void deleteById(Long id);





}
