package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payee {

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("merchant_id")
    private String merchantId;
}