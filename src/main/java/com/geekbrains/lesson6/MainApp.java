package com.geekbrains.lesson6;

import com.geekbrains.lesson6.repositories.SessionFactoryUtils;
import com.geekbrains.lesson6.servises.FinderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.lesson6")) {
            SessionFactoryUtils factory = context.getBean(SessionFactoryUtils.class);
            FinderService finderService = context.getBean(FinderService.class);
            factory.init();
            finderService.setFactory(factory);

            finderService.getListProductsByUserId(1L);// Ищет и печатает лист продуктов у пользователя с указанным ID

            finderService.getListUsersByProductId(3L);// Ищет и печатает лист пользователей приобретавших продукт с указанным ID

        }


    }
}







