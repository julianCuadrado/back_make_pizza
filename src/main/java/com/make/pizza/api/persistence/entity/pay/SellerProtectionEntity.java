package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "seller_protection")
public class SellerProtectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ElementCollection(targetClass = String.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "dispute_categories")
    @Column(name = "category")
    private List<String> disputeCategories;
}