package com.make.pizza.api.persistence.repository;

import com.make.pizza.api.persistence.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}