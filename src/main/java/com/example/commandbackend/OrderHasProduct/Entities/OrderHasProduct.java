package com.example.commandbackend.OrderHasProduct.Entities;

import com.example.commandbackend.Orders.Entities.Orders;
import com.example.commandbackend.Products.Enums.ProductStatusEnum;
import com.example.commandbackend.Products.Entities.Products;
import jakarta.persistence.*;

@Table(name = "orderHasProduct")
@Entity(name = "orderHasProduct")
public class OrderHasProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;

    public OrderHasProduct(int quantity, Orders order, ProductStatusEnum productStatus, Products product) {
        this.quantity = quantity;
        this.order = order;
        this.productStatus = productStatus;
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;
    @Column
    private ProductStatusEnum productStatus;

    public OrderHasProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public ProductStatusEnum getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatusEnum productStatus) {
        this.productStatus = productStatus;
    }
}
