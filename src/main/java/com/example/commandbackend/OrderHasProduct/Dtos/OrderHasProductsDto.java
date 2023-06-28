package com.example.commandbackend.OrderHasProduct.Dtos;

import com.example.commandbackend.Products.Dtos.ProductDto;

public class OrderHasProductsDto {
    public Long id;
    public int quantity;
    public ProductDto product;

    public OrderHasProductsDto(Long id, int quantity, ProductDto product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }
}
