package com.example.commandbackend.Products.Dtos;

import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;

import java.util.List;

public class GroupedByCategory {
    public ProductCategoryDto productCategory;
    public List<ProductDto> products;
}
