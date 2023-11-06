package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "amount")
public class AmountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency_code")
    private String currencyCode;
    @Column(name = "amount_value")
    private String value;
}