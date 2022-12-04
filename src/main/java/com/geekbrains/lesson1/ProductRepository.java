package com.geekbrains.lesson1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;


    @PostConstruct
    private void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "MyPhoneX", 25000.00),
                new Product(2, "TV Samgnus", 20000.00),
                new Product(3, "TVbox IM", 10000.00),
                new Product(4, "StantionPlay III", 13000.00),
                new Product(5, "Headphones SuperSound2", 5000.00)
        ));
    }

    public void showAllProducts() {
        System.out.println("Список товаров магазина: ");
        productList.stream().map(Product::toString).forEach(System.out::println);
    }


    public Product getProductById(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

}
