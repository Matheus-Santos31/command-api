package com.example.commandbackend.ProductIngredients;

import com.example.commandbackend.Ingredients.Entities.Ingredients;
import com.example.commandbackend.Ingredients.IngredientsRepository;
import com.example.commandbackend.Ingredients.IngredientsService;
import com.example.commandbackend.ProductIngredients.Dtos.ProductIngredientsDto;
import com.example.commandbackend.ProductIngredients.Entities.ProductIngredients;
import com.example.commandbackend.Products.Entities.Products;
import com.example.commandbackend.Products.ProductsRepository;
import com.example.commandbackend.Products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductIngredientsService {
    @Autowired
    private ProductIngredientsRepository productIngredientsRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<ProductIngredients> getProductIngredientsByProductId(Long id){
        List<ProductIngredients> productIngredientsList = productIngredientsRepository.findAll().stream().filter(pi -> pi.getProduct().getId() == id).toList();
        return productIngredientsList;
    }

    public String createProductIngredients(Long productId, ArrayList<Long> ingredientsIds) throws Exception {
        ArrayList<ProductIngredients> productIngredientsList = new ArrayList<ProductIngredients>();
        System.out.println(productId);
        Products product = productsRepository.findById(productId).get();
        boolean a = product == null;
        System.out.println(a);
        if(product == null)
            throw new Exception("Product not found");

        for (Long ingredientId:ingredientsIds
             ) {
            Ingredients ingredient = ingredientsRepository.findById(ingredientId).get();
            if(ingredient == null)
                throw new Exception("Ingredient not found");

            ProductIngredients newProduct = new ProductIngredients(product, ingredient);
            productIngredientsList.add(newProduct);
        }

        productIngredientsRepository.saveAll(productIngredientsList);

        return "Success";
    }
}
