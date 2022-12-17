package com.geekbrains.lesson6.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Basic
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(name = "id_products", referencedColumnName = "id", nullable = false)
    private Products product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
