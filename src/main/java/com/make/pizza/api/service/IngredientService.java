package com.make.pizza.api.service;

import com.make.pizza.api.persistence.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> listarTodos();
}
