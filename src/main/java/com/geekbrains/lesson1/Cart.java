package com.geekbrains.lesson1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


import static com.geekbrains.lesson1.MainApp.log;

@Component
@Scope("prototype")
public class Cart {
    List<Product> listCart;
    private static int counter = 1;
    private int id;

    ProductRepository productRepository;

    public Cart() {
        listCart = new ArrayList<>();
        this.id = counter++;

    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id) {
        listCart.add(productRepository.getProductById(id));
        log.info("Добавлен товар: "+productRepository.getProductById(id));

    }

    public void deleteProduct(int id){
        listCart.removeIf(p->p.getId()==id);
        log.info("Удален товар: "+productRepository.getProductById(id));

    }
    public void showCart(){
        System.out.println("\nСписок корзины № "+id + " :");
        listCart.forEach(System.out::println);
    }


}
