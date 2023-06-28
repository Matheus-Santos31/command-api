package com.example.commandbackend.Orders.Entities;

import com.example.commandbackend.BillHasOrder.Entities.BillHasOrder;
import com.example.commandbackend.Clients.Entities.Clients;
import com.example.commandbackend.OrderHasProduct.Entities.OrderHasProduct;
import com.example.commandbackend.Orders.Enums.OrderStatusEnum;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "orders")
@Entity(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Clients client;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<BillHasOrder> BillHasOrder;

    @Column
    private OrderStatusEnum orderStatus;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderHasProduct> orderHasProductList;

    public Orders() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public List<com.example.commandbackend.BillHasOrder.Entities.BillHasOrder> getBillHasOrder() {
        return BillHasOrder;
    }

    public void setBillHasOrder(List<com.example.commandbackend.BillHasOrder.Entities.BillHasOrder> billHasOrder) {
        BillHasOrder = billHasOrder;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderHasProduct> getOrderHasProductList() {
        return orderHasProductList;
    }

    public void setOrderHasProductList(List<OrderHasProduct> orderHasProductList) {
        this.orderHasProductList = orderHasProductList;
    }
}
