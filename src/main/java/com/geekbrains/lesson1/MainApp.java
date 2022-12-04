package com.geekbrains.lesson1;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static Logger log = Logger.getLogger("stdout");
    private static boolean quit;
    private static boolean quitCart;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.lesson1");
        Cart cart = context.getBean(Cart.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println("Добро пожаловать в магазин!");

        Scanner sc = new Scanner(System.in);
        while (!quit) {
            menuInfo("mainMenu");
            int input = sc.nextInt();

            if (1 == input) {
                productRepository.showAllProducts();
            }
            if ((2 == input)) {
                quitCart = false;
                menuInfo("cartMenu");
                while (!quitCart) {
                    input = sc.nextInt();
                    switch (input) {
                        case 1 -> {
                            System.out.println("Введите id товара для добавления в корзину.");
                            input = sc.nextInt();
                            cart.addProduct(input);
                            menuInfo("cartMenu");
                        }
                        case 2 -> {
                            System.out.println("Введите id товара для удаления из корзины.");
                            input = sc.nextInt();
                            cart.deleteProduct(input);
                            menuInfo("cartMenu");
                        }
                        case 3 -> {
                            cart.showCart();
                            menuInfo("cartMenu");
                        }
                        case 4 -> quitCart = true;
                        default -> System.out.println("Введены неккоретные данные");
                    }
                }

            }
            if (3 == input) {
                System.out.println("До скорого!");
                quit = true;
            }

        }
    }

    private static void menuInfo(String category) {
        switch (category) {
            case "mainMenu" ->
                    System.out.println("\nВведите: \n 1 - Посмотреть все товары. \n 2 - Перейти в корзину.\n 3 - Выход.");
            case "cartMenu" -> System.out.println("\nМеню корзины:\n1 - Добавить товар в корзину.\n" +
                    "2 - Удалить товар из корзины.\n" +
                    "3 - Посмотреть содержимое корзины\n" +
                    "4 - Назад");
        }
    }
}

