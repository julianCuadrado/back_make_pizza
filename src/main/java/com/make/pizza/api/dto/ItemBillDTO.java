package com.make.pizza.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemBillDTO {

    private Long id;
    private Double amount;
    private String description;
    private Double unitValue;
    private Double totalValue;
}