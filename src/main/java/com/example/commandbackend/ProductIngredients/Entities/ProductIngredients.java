package com.example.commandbackend.ProductIngredients.Entities;

import com.example.commandbackend.Ingredients.Entities.Ingredients;
import com.example.commandbackend.Products.Entities.Products;
import jakarta.persistence.*;

@Table(name = "productIngredients")
@Entity(name = "productIngredients")
public class ProductIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;
    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredients ingredient;

    public ProductIngredients(Products product, Ingredients ingredient) {
        this.product = product;
        this.ingredient = ingredient;
    }

    public ProductIngredients() {

    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }
}
