package com.make.pizza.api.service;

import com.make.pizza.api.dto.BillDTO;
import com.make.pizza.api.dto.OrderDTO;
import com.make.pizza.api.persistence.entity.BillEntity;
import com.make.pizza.api.persistence.entity.pay.PayPalOrderEntity;

import java.util.List;

public interface BillService {

    BillEntity save(OrderDTO order, PayPalOrderEntity payPalOrderEntity);

    List<BillDTO> getAllActive();
}
