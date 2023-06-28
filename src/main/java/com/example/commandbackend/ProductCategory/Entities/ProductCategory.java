package com.example.commandbackend.ProductCategory.Entities;

import jakarta.persistence.*;

@Table(name = "productCategory")
@Entity(name = "productCategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;

    public ProductCategory() {

    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory(String descricao){
        this.description = descricao;
    }
}
