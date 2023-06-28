package com.example.commandbackend.ProductIngredients;

import com.example.commandbackend.ProductIngredients.Entities.ProductIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductIngredientsRepository extends JpaRepository<ProductIngredients, Long> {
}
