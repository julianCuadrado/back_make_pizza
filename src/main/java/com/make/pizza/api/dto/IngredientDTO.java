package com.make.pizza.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IngredientDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String urlImage;
    private Boolean enabled;
}