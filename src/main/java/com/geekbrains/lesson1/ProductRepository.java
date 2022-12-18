package com.geekbrains.lesson1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Products> productsList;

    @PostConstruct
    private void init() {
        productsList = new ArrayList<>(Arrays.asList(
                new Products(1, "MyPhoneX", 25000.00),
                new Products(2, "TV Samgnus", 20000.00),
                new Products(3, "TVbox IM", 10000.00),
                new Products(4, "StantionPlay III", 13000.00),
                new Products(5, "Headphones SuperSound2", 5000.00)
        ));
    }

    public void showAllProducts() {
        System.out.println("Список товаров магазина: ");
        productsList.stream().map(Products::toString).forEach(System.out::println);
    }

    public Products getProductById(int id) {
        return productsList.stream().filter(products -> products.getId() == id).findFirst().orElse(null);
    }

}
