package com.make.pizza.api.dto.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Capture {

    private String id;
    private String status;
    private Amount amount;

    @JsonProperty("final_capture")
    private boolean finalCapture;

    @JsonProperty("seller_protection")
    private SellerProtection sellerProtection;

    @JsonProperty("create_time")
    private String createTime;

    @JsonProperty("update_time")
    private String updateTime;
}