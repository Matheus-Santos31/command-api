package com.example.commandbackend.Products;

import com.example.commandbackend.Commom.BaseRequestResult.BaseRequestResult;
import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;
import com.example.commandbackend.Products.Dtos.CreateProductDto;
import com.example.commandbackend.Products.Dtos.GroupedByCategory;
import com.example.commandbackend.Products.Dtos.ProductDto;
import com.example.commandbackend.Products.Entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping
    public BaseRequestResult createProduct(@RequestBody CreateProductDto product){
        try{
            Products newProduct = productsService.createProduct(product);
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

    @GetMapping
    public BaseRequestResult<List<ProductDto>> getAll(){
        try{
            List<ProductDto> productsList = productsService.getAllProducts();
            System.out.println(productsList);
            return new BaseRequestResult<List<ProductDto>>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found Successfully",
                    productsList
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

    @GetMapping("/{id}")
    public BaseRequestResult<ProductDto> getById(@PathVariable Long id){
        try{
            Products product = productsService.getById(id).get();
            return new BaseRequestResult<ProductDto>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found Successfully",
                    new ProductDto(
                            product.getId().describeConstable(),
                            product.getName(),
                            product.getValue(),
                            product.isHasStock(),
                            product.isBlocked(),
                            product.isCustom(),
                            product.getImageUrl(),
                            product.getCategoryId(),
                            new ProductCategoryDto(
                                    product.getCategory().getId(),
                                    product.getCategory().getDescription()
                            ))
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
            String response = productsService.deleteById(id);
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
    public BaseRequestResult update(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        try{
            String response = productsService.updateProduct(id, productDto);
            return new BaseRequestResult(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Updated Successfully"
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

    @GetMapping("groupedByCategory")
    public BaseRequestResult<List<GroupedByCategory>> getAllGroupedByCategory(){
        try{
            List<GroupedByCategory> response = productsService.getAllProductsGroupedByCategory();
            return new BaseRequestResult<List<GroupedByCategory>>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found Successfully",
                    response
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
