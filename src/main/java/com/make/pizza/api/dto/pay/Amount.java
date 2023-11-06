package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {
    @JsonProperty("currency_code")
    private String currencyCode;

    private String value;
}