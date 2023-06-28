package com.example.commandbackend.Ingredients.Dtos;

import java.util.Optional;

public class IngredientsDto {
    public Optional<Long> id;
    public String description;
    public Float price;
    public Integer units;
    public boolean hasStock;

    public IngredientsDto(Optional<Long> id,String description, Float price, Integer units, boolean hasStock) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.units = units;
        this.hasStock = hasStock;
    }
}
