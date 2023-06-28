package com.example.commandbackend.Orders.Dtos;

import com.example.commandbackend.Products.Dtos.ProductDto;

import java.util.List;

public class CreateOrderDto {
    public Long clientId;
    public List<OrderProductDto> productsList;
}
