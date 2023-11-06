package com.make.pizza.api.service;

import com.make.pizza.api.dto.pay.PayPalOrder;
import com.make.pizza.api.persistence.entity.pay.PayPalOrderEntity;

public interface PayPalOrderService {

    PayPalOrderEntity save(PayPalOrder payPalOrder);
}