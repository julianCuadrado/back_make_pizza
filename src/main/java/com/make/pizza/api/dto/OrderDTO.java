package com.make.pizza.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private Long id;
    private LocalDateTime dateOrder;
    private Double longitude;
    private Double latitude;
    private String direction;
    private List<OrderItemDTO> items;
    private Boolean enabled;
    private UserDTO user;
    private Double total;
}