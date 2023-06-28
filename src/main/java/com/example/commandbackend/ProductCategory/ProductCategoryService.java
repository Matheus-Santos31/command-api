package com.example.commandbackend.ProductCategory;

import com.example.commandbackend.ProductCategory.Dtos.CreateProductCategoryDto;
import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory createProductCategory(CreateProductCategoryDto productCategoryDto){
        ProductCategory productCategory = new ProductCategory(productCategoryDto.description);

        ProductCategory newProductCategory = productCategoryRepository.save(productCategory);
        return newProductCategory;
    }

    public List<ProductCategoryDto> getAll(){
        List<ProductCategoryDto> productCategoryList = productCategoryRepository.findAll().stream().map(category -> new ProductCategoryDto(category.getId(), category.getDescription())).toList();
        return productCategoryList;
    }

    public String delete(Long id){
        productCategoryRepository.deleteById(id);
        return "Success";
    }

    public String update(Long id, ProductCategoryDto productCategoryInfo) throws Exception {
        ProductCategory productCategory = productCategoryRepository.findById(id).get();
        if(productCategory == null)
            throw new Exception("Category not found!");

        productCategory.setDescription(productCategoryInfo.description);


        productCategoryRepository.save(productCategory);

        return "Success";
    }
}
