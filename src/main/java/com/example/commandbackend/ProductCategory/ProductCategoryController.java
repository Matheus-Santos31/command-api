package com.example.commandbackend.ProductCategory;

import com.example.commandbackend.Commom.BaseRequestResult.BaseRequestResult;
import com.example.commandbackend.ProductCategory.Dtos.CreateProductCategoryDto;
import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public BaseRequestResult<List<ProductCategoryDto>> getAll(){
        try{
            List<ProductCategoryDto> productCategoryDtoList = productCategoryService.getAll();
            return new BaseRequestResult<List<ProductCategoryDto>>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found Successfully",
                    productCategoryDtoList
            );
        }
        catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }
    @PostMapping
    public BaseRequestResult create(@RequestBody CreateProductCategoryDto productCategoryDto){
        try{
            ProductCategory productCategory = productCategoryService.createProductCategory(productCategoryDto);
            return new BaseRequestResult(
                    HttpStatus.CREATED,
                    HttpStatus.CREATED.value(),
                    "Created Successfully"
            );
        }
        catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }
    @DeleteMapping("/{id}")
    public BaseRequestResult delete(@PathVariable("id") Long id){
        try{
            String response = productCategoryService.delete(id);
            return new BaseRequestResult(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Deleted Successfully"
            );
        }
        catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }
    @PatchMapping("/{id}")
    public BaseRequestResult update(@PathVariable("id") Long id, @RequestBody ProductCategoryDto categoryDto){
        try{
            String response = productCategoryService.update(id, categoryDto);
            return new BaseRequestResult(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Updated Successfuly"
            );
        }
        catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }
}
