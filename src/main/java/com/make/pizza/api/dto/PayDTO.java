package com.make.pizza.api.dto;

import com.make.pizza.api.dto.pay.PayPalOrder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PayDTO implements Serializable {

    private PayPalOrder payPalOrder;
    private OrderDTO order;
}