package com.geekbrains.lesson6;

import com.geekbrains.lesson6.repositories.SessionFactoryUtils;
import com.geekbrains.lesson6.servises.FinderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.lesson6")) {
            SessionFactoryUtils factory = context.getBean(SessionFactoryUtils.class);
            FinderService finderService = context.getBean(FinderService.class);
            factory.init();
            finderService.setFactory(factory);
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.printf("%nВведите:%n1 - Выести лист продуктов у пользователя с указанным ID.%n" +
                        "2 - Выести лист пользователей приобретавших продукт с указанным ID.%n" +
                        "3 - Выход%n");
                Long input = sc.nextLong();
                if (input == 1) {
                    System.out.printf("%nВведите ID пользователя. Количество пользователей - %s%n",finderService.getAllUsersSize());
                    input = sc.nextLong();
                    finderService.getListProductsByUserId(input);// Ищет и печатает лист продуктов у пользователя с указанным ID
                } else if (input == 2) {
                    System.out.printf("%nВведите ID продукта. Количество продуктов - %s%n",finderService.getAllProductsSize());
                    input = sc.nextLong();
                    finderService.getListUsersByProductId(input);// Ищет и печатает лист пользователей приобретавших продукт с указанным ID
                } else if (input == 3) {
                    break;
                } else System.out.println("Некорректные данные!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка данных!");
        }
    }
}








