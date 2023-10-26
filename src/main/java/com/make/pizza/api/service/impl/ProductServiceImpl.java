package com.make.pizza.api.service.impl;

import com.make.pizza.api.persistence.entity.Product;
import com.make.pizza.api.persistence.repository.ProductRepository;
import com.make.pizza.api.persistence.util.ProductType;
import com.make.pizza.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllPizzas() {
        return productRepository.findByproductType(ProductType.PIZZA);
    }

    @Override
    public List<Product> getAllDrinks() {
        return productRepository.findByproductType(ProductType.BEBIDA);
    }

    @Override
    public List<Product> getAllAdditional() {
        return productRepository.findByproductType(ProductType.ADICIONAL);
    }
}
