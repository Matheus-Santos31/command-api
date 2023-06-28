package com.example.commandbackend.Products.Dtos;

import java.util.ArrayList;

public class CreateProductDto {
    public String name;
    public Float value;
    public boolean hasStock;
    public boolean blocked;
    public boolean custom;
    public String imageUrl;
    public Long categoryId;
    public ArrayList<Long> ingredientsIds;
}
