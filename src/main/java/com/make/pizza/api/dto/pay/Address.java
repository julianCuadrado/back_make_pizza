package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    @JsonProperty("address_line_1")
    private String addressLine1;

    @JsonProperty("admin_area_2")
    private String adminArea2;

    @JsonProperty("admin_area_1")
    private String adminArea1;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("country_code")
    private String countryCode;
}