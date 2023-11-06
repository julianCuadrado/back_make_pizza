package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name {

    @JsonProperty("given_name")
    private String givenName;
    private String surname;
    @JsonProperty("full_name")
    private String fullName;
}