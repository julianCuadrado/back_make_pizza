package com.make.pizza.api.persistence.entity;

import com.make.pizza.api.persistence.util.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductType productType;
    private String urlImage;
    private Double price;
    private boolean enabled;
    @ManyToMany
    @JoinTable(
            name = "products_ingredients",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;
}