package com.example.commandbackend.Ingredients;

import com.example.commandbackend.Commom.BaseRequestResult.BaseRequestResult;
import com.example.commandbackend.Ingredients.Dtos.IngredientsDto;
import com.example.commandbackend.Ingredients.Entities.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("ingredients")
public class IngredientsController {
    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping
    public BaseRequestResult<List<IngredientsDto>> getAll(){
        try{
            List<IngredientsDto> ingredientsList = ingredientsService.getAll();
            return new BaseRequestResult<List<IngredientsDto>>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found Succesfully",
                    ingredientsList
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
    public BaseRequestResult<IngredientsDto> getById(@PathVariable("id") Long id){
        try{
            IngredientsDto ingredient = ingredientsService.getById(id);
            return new BaseRequestResult<IngredientsDto>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found successfully",
                    ingredient
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
    public BaseRequestResult create(@RequestBody IngredientsDto createIngredients){
        try{
            Ingredients ingredients = ingredientsService.create(createIngredients);
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
            String response = ingredientsService.delete(id);
            return new BaseRequestResult(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Deleted successfully"
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
    public BaseRequestResult update(@PathVariable("id") Long id, @RequestBody IngredientsDto ingredient){
        try{
            String response = ingredientsService.update(id, ingredient);
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
}
