package com.geekbrains.lesson1;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static Logger log = Logger.getLogger("stdout");
    private static boolean quit;


    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.lesson1")) {
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
                    boolean quitCart = false;
                    menuInfo("cartMenu");
                    while (!quitCart) {
                        input = sc.nextInt();
                        switch (input) {
                            case 1 -> {
                                System.out.println("Введите ID товара для добавления в корзину.");
                                input = sc.nextInt();
                                cart.addProduct(input);
                                menuInfo("cartMenu");
                            }
                            case 2 -> {
                                System.out.println("Введите ID товара для удаления из корзины.");
                                input = sc.nextInt();
                                cart.deleteProduct(input);
                                menuInfo("cartMenu");
                            }
                            case 3 -> {
                                cart.showCart();
                                menuInfo("cartMenu");
                            }
                            case 4 -> quitCart = true;
                            default -> System.out.println("Введены неккоректные данные! Попробуйте еще раз!");
                        }
                    }

                }
                if (3 == input) {
                    System.out.println("Введите ID товара для его поиска.");
                    input = sc.nextInt();
                    if (productRepository.getProductById(input) != null) {
                        System.out.println("\nРезультат поиска:\n" + productRepository.getProductById(input) + "\n");
                    } else System.out.println("\nРезультат поиска:\nТовар с данным ID не найден!\n");
                    input = 0;

                }
                if (4 == input) {
                    System.out.println("До скорого!");
                    quit = true;
                }
                if (input > 4) System.out.println("Введены неккоректные данные! Попробуйте еще раз!");

            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    private static void menuInfo(String category) {
        switch (category) {
            case "mainMenu" -> System.out.println("""
                    Введите: 
                    1 - Посмотреть все товары.
                    2 - Перейти в корзину.
                    3 - Поиск товра по ID
                    4 - Выход.""");
            case "cartMenu" -> System.out.println("""
                    Меню корзины:
                    1 - Добавить товар в корзину.
                    2 - Удалить товар из корзины.
                    3 - Посмотреть содержимое корзины
                    4 - Назад""");
        }
    }
}

