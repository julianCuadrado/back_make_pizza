package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PayPalOrder {

    private String id;
    private String intent;
    private String status;

    @JsonProperty("purchase_units")
    private List<PurchaseUnit> purchaseUnits = new ArrayList<>();

    private Payer payer;

    @JsonProperty("create_time")
    private String createTime;

    @JsonProperty("update_time")
    private String updateTime;

    private List<Link> links = new ArrayList<>();
}