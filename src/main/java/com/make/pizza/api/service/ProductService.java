package com.make.pizza.api.service;

import com.make.pizza.api.persistence.entity.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAllPizzas();

    List<Product> getAllDrinks();

    List<Product> getAllAdditional();
}
