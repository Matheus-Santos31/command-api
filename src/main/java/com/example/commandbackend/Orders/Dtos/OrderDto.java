package com.example.commandbackend.Orders.Dtos;

import com.example.commandbackend.Clients.Dtos.ClientDto;
import com.example.commandbackend.OrderHasProduct.Dtos.OrderHasProductsDto;
import com.example.commandbackend.Orders.Enums.OrderStatusEnum;

import java.util.List;

public class OrderDto {
    public Long id;
    public OrderStatusEnum orderStatus;
    public ClientDto client;
    public List<OrderHasProductsDto> OrderHasProductList;

    public OrderDto(Long id, OrderStatusEnum orderStatus, ClientDto client, List<OrderHasProductsDto> orderHasProductList) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.client = client;
        OrderHasProductList = orderHasProductList;
    }
}
