package com.example.commandbackend.Ingredients;

import com.example.commandbackend.Ingredients.Dtos.IngredientsDto;
import com.example.commandbackend.Ingredients.Entities.Ingredients;
import com.example.commandbackend.ProductCategory.Dtos.ProductCategoryDto;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    public Ingredients create(IngredientsDto ingredientsDto){
        Ingredients ingredients = new Ingredients(ingredientsDto.description, ingredientsDto.price, ingredientsDto.units, ingredientsDto.hasStock);

        Ingredients newIngredient = ingredientsRepository.save(ingredients);
        return newIngredient;
    }

    public List<IngredientsDto> getAll(){
        List<IngredientsDto> ingredientsList = ingredientsRepository.findAll().stream().map(ingredient -> new IngredientsDto(ingredient.getId().describeConstable() ,ingredient.getDescription(), ingredient.getPrice(), ingredient.getUnits(), ingredient.isHasStock())).toList();
        return ingredientsList;
    }

    public String delete(Long id){
        ingredientsRepository.deleteById(id);
        return "Success";
    }

    public IngredientsDto getById(Long id) throws Exception {
        Ingredients ingredients = ingredientsRepository.findById(id).get();
        if(ingredients == null) throw new Exception("Not found");

        IngredientsDto ingredientsResult = new IngredientsDto(
                ingredients.getId().describeConstable(),
                ingredients.getDescription(),
                ingredients.getPrice(),
                ingredients.getUnits(),
                ingredients.isHasStock());

        return ingredientsResult;
    }

    public String update(Long id, IngredientsDto ingredientsInfo) throws Exception {
        Ingredients ingredient = ingredientsRepository.findById(id).get();
        if(ingredient == null)
            throw new Exception("Category not found!");

        ingredient.setDescription(ingredientsInfo.description);
        ingredient.setPrice(ingredientsInfo.price);
        ingredient.setUnits(ingredientsInfo.units);
        ingredient.setHasStock(ingredientsInfo.hasStock);
        ingredientsRepository.save(ingredient);

        return "Success";
    }
}
