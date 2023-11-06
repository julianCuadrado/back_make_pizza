package com.make.pizza.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BillDTO {

    private Long id;
    private LocalDateTime dateBill;
    private Double total;
    private String fullNameClient;
    private Double longitude;
    private Double latitude;
    private String addressClient;
    private List<ItemBillDTO> items;
}