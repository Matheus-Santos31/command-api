package com.example.commandbackend.Products.Entities;

import com.example.commandbackend.OrderHasProduct.Entities.OrderHasProduct;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;
import com.example.commandbackend.ProductIngredients.Entities.ProductIngredients;
import com.example.commandbackend.Products.Dtos.CreateProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "products")
@Entity(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Float value;
    @Column
    private boolean hasStock;
    @Column
    private boolean blocked;
    @Column
    private boolean custom;
    @Column
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private ProductCategory category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderHasProduct> orderHasProductList;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductIngredients> productIngredientsList;

    public Products(String name, Float value, boolean hasStock, boolean blocked, boolean custom, String imageUrl){
        this.name = name;
        this.value = value;
        this.hasStock = hasStock;
        this.blocked = blocked;
        this.custom = custom;
        this.imageUrl = imageUrl;
    }

    public Products(CreateProductDto productInfo){
        this.name = productInfo.name;
        this.value = productInfo.value;
        this.hasStock = productInfo.hasStock;
        this.blocked = productInfo.blocked;
        this.custom = productInfo.custom;
        this.imageUrl = productInfo.imageUrl;
    }

    public Products() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Long getCategoryId() {
        return this.category.getId();
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<OrderHasProduct> getOrderHasProductList() {
        return orderHasProductList;
    }

    public void setOrderHasProductList(List<OrderHasProduct> orderHasProductList) {
        this.orderHasProductList = orderHasProductList;
    }

    public List<ProductIngredients> getProductIngredientsList() {
        return productIngredientsList;
    }

    public void setProductIngredientsList(List<ProductIngredients> productIngredientsList) {
        this.productIngredientsList = productIngredientsList;
    }
}
