package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseUnit {

    @JsonProperty("reference_id")
    private String referenceId;
    private Amount amount;
    private Payee payee;
    private Shipping shipping;
    private Payments payments;
}