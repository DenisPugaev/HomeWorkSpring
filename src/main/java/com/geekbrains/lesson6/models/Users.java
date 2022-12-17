package com.geekbrains.lesson6.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "users")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private Collection<Orders> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Collection<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Orders> orders) {
        this.orders = orders;
    }
}
