package com.make.pizza.api.service.impl;

import com.make.pizza.api.persistence.entity.Ingredient;
import com.make.pizza.api.persistence.repository.IngredientRepository;
import com.make.pizza.api.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> listarTodos() {
        return ingredientRepository.findAll();
    }
}