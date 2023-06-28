package com.example.commandbackend.Products;

import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;
import com.example.commandbackend.ProductCategory.ProductCategoryRepository;
import com.example.commandbackend.ProductIngredients.ProductIngredientsService;
import com.example.commandbackend.Products.Dtos.CreateProductDto;
import com.example.commandbackend.Products.Dtos.GroupedByCategory;
import com.example.commandbackend.Products.Dtos.ProductDto;
import com.example.commandbackend.Products.Entities.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductIngredientsService productIngredientsService;

    @Autowired
    private EntityManager entityManager;

    public Products createProduct(CreateProductDto productInfo) throws Exception {
        Products newProduct = new Products(productInfo);

        if(productInfo.categoryId != null){
            ProductCategory category = productCategoryRepository.findById(productInfo.categoryId).get();
            if(category == null)
                throw new Exception("Category not found");

            newProduct.setCategory(category);
        }

        Products newProductResponse = productsRepository.save(newProduct);

        if(productInfo.ingredientsIds != null && productInfo.ingredientsIds.stream().count() > 0){
            System.out.println(productInfo.ingredientsIds.get(0));
            productIngredientsService.createProductIngredients(newProductResponse.getId(), productInfo.ingredientsIds);
        }

        return newProductResponse;
    }

    public List<ProductDto> getAllProducts(){
        List<ProductDto> productsList = this.getAll().stream().map(products -> new ProductDto( products.getId().describeConstable(), products.getName(), products.getValue(), products.isHasStock(), products.isBlocked(), products.isCustom(), products.getImageUrl(), products.getCategoryId(), new ProductCategoryDto(products.getCategoryId(), products.getCategory().getDescription()))).toList();
        return productsList;
    }

    public List<GroupedByCategory> getAllProductsGroupedByCategory(){
        Map<ProductCategoryDto, List<ProductDto>> productsList = this.getAllProducts().stream()
                .collect(Collectors.groupingBy(ProductDto::getCategory));

        return productsList.entrySet().stream()
                .map(productCategoryDtoListEntry -> {
                    GroupedByCategory groupedByCategory = new GroupedByCategory();
                    groupedByCategory.productCategory = productCategoryDtoListEntry.getKey();
                    groupedByCategory.products = productCategoryDtoListEntry.getValue();
                    return groupedByCategory;
                }).collect(Collectors.toList());
    }

    public List<Products> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Products> query = cb.createQuery(Products.class);
        Root<Products> products = query.from(Products.class);
        Join<Products, ProductCategory> join = products.join("category", JoinType.INNER);

        // Add conditions or predicates if needed
        // query.where(...);

        query.select(products);

        return entityManager.createQuery(query).getResultList();
    }

    public Optional<Products> getById(Long id){
        return productsRepository.findById(id);
    }

    public String deleteById(Long id){
        productsRepository.deleteById(id);

        return "Success";
    }

    public String updateProduct(Long id, ProductDto newProductInfo) throws Exception {
        Products product = productsRepository.findById(id).get();
        if(product == null)
            throw new Exception("Product not found");

        ProductCategory category = productCategoryRepository.findById(newProductInfo.categoryId).get();
        if(category == null)
            throw new Exception("Category not found");

        product.setName(newProductInfo.name);
        product.setValue(newProductInfo.value);
        product.setHasStock(newProductInfo.hasStock);
        product.setBlocked(newProductInfo.blocked);
        product.setCustom(newProductInfo.custom);
        product.setImageUrl(newProductInfo.imageUrl);
        product.setCategory(category);
        productsRepository.save(product);

        return "Success";
    }
}
