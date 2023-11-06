package com.make.pizza.api.service.impl;

import com.make.pizza.api.dto.PayDTO;
import com.make.pizza.api.persistence.entity.BillEntity;
import com.make.pizza.api.persistence.entity.pay.PayPalOrderEntity;
import com.make.pizza.api.service.BillService;
import com.make.pizza.api.service.OrderService;
import com.make.pizza.api.service.PayPalOrderService;
import com.make.pizza.api.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PayServiceImpl implements PayService {

    private final PayPalOrderService payPalOrderService;
    private final BillService billService;
    private final OrderService orderService;

    @Override
    public void processPay(PayDTO payDTO) {
        PayPalOrderEntity payPalOrderEntity = payPalOrderService.save(payDTO.getPayPalOrder());
        BillEntity billEntity = billService.save(payDTO.getOrder(), payPalOrderEntity);
        orderService.desabledOrder(payDTO.getOrder().getId());
    }
}