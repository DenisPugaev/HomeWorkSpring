package com.geekbrains.lesson6.repositories;


import com.geekbrains.lesson6.models.Products;

import java.util.List;

public interface ProductDao {
    List<Products> findAll();

    Products findById(Long id);
    Products findByName(String name);

    void save(Products products);

    void deleteById(Long id);


}
