package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payer {

    private Name name;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("payer_id")
    private String payerId;

    private Address address;

}