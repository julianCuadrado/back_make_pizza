package com.make.pizza.api.service;

import com.make.pizza.api.persistence.entity.UserOrder;

public interface OrderService {
    void saveOrder(UserOrder userOrder);
    UserOrder getCurrentOrder();

    void desabledOrder(Long idOrder);
}