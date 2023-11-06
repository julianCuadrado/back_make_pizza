package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SellerProtection {

    private String status;

    @JsonProperty("dispute_categories")
    private List<String> disputeCategories;
}