package com.make.pizza.api.controller;

import com.make.pizza.api.persistence.entity.Product;
import com.make.pizza.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllPizzas() {
        return productService.getAllPizzas();
    }

    @GetMapping("/drinks")
    public List<Product> getAllDrinks() {
        return productService.getAllDrinks();
    }

    @GetMapping("/additional")
    public List<Product> getAlladditional() {
        return productService.getAllAdditional();
    }
}