package com.geekbrains.lesson6.servises;


import com.geekbrains.lesson6.models.Orders;
import com.geekbrains.lesson6.models.Products;
import com.geekbrains.lesson6.models.Users;
import com.geekbrains.lesson6.repositories.*;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class FinderService {
    private SessionFactoryUtils factory;





    public void setFactory(SessionFactoryUtils factory) {
        this.factory = factory;
    }


    public void getListUsersByProductId(Long id) {
        ProductDao productDao = new ProductDaoImpl(factory);
        Products product = productDao.findById(id);
        Collection<Orders> orders1 =  product.getOrders();
        System.out.printf("%nКоличество заказов продукта %s [ID:%s]: %s%n",product.getName(),product.getId(),orders1.size());
        int counter = 0;
        for (Orders order : orders1) {
            counter++;
            System.out.printf("%s) [ID:%s] %s %n",counter,order.getUser().getId(),order.getUser().getName());
        }


    }

    public void getListProductsByUserId(Long id) {
        UserDao userDao = new UserDaoImpl(factory);
        Users user = userDao.findById(id);
        Collection<Orders> orders2 =  user.getOrders();
        System.out.printf("%nКоличество заказов у пользоваетеля %s: %s %n",user.getName(),orders2.size());
        int counter = 0;
        for (Orders order : orders2) {
            counter++;
            System.out.printf("%s) [ID:%s] %s Стоимость товара: %s р %n",counter,order.getProduct().getId(),order.getProduct().getName(),order.getProduct().getCost());
        }
    }

    public int getAllProductsSize(){
        ProductDao  product= new ProductDaoImpl(factory);
       List<Products> productsList = product.findAll();
        return productsList.size();
    }
    public int getAllUsersSize(){
        UserDao  user= new UserDaoImpl(factory);
        List<Users> usersList = user.findAll();
        return usersList.size();
    }

}



