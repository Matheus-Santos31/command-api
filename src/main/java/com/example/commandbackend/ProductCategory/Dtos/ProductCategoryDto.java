package com.example.commandbackend.ProductCategory.Dtos;

public class  ProductCategoryDto {
    public Long id;
    public String description;

    public ProductCategoryDto(Long id,String description) {
        this.id = id;
        this.description = description;
    }
}
