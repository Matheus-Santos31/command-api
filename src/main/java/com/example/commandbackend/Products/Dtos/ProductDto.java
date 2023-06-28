package com.example.commandbackend.Products.Dtos;

import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ProductDto{
    public Optional<Long> id;
    public String name;
    public Float value;
    public boolean hasStock;
    public boolean blocked;
    public boolean custom;
    public String imageUrl;
    public Long categoryId;

    public ProductCategoryDto getCategory() {
        return category;
    }

    public ProductCategoryDto category;

    public ProductDto(Optional<Long> id, String name, Float value, boolean hasStock, boolean blocked, boolean custom, String imageUrl, Long categoryId, ProductCategoryDto category) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.hasStock = hasStock;
        this.blocked = blocked;
        this.custom = custom;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.category = category;
    }
}
