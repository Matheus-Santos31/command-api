package com.example.commandbackend.Ingredients;

import com.example.commandbackend.Ingredients.Entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
}
