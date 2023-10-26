package com.make.pizza.api.persistence.repository;

import com.make.pizza.api.persistence.entity.Product;
import com.make.pizza.api.persistence.util.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByproductType(ProductType productType);
}
