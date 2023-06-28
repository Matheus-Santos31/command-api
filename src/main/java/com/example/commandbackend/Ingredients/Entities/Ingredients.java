package com.example.commandbackend.Ingredients.Entities;

import com.example.commandbackend.ProductIngredients.Entities.ProductIngredients;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "ingredients")
@Entity(name = "ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column
    private Float price;
    @Column
    private Integer units;
    @Column
    private boolean hasStock;
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<ProductIngredients> productIngredientsList;

    public Ingredients(String description, Float price, Integer units, boolean hasStock) {
        this.description = description;
        this.price = price;
        this.units = units;
        this.hasStock = hasStock;
    }

    public Ingredients() {

    }

    public Long getId(){
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }

    public List<ProductIngredients> getProductIngredientsList() {
        return productIngredientsList;
    }

    public void setProductIngredientsList(List<ProductIngredients> productIngredientsList) {
        this.productIngredientsList = productIngredientsList;
    }
}
