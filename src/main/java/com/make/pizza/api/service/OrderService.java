package com.make.pizza.api.service;

import com.make.pizza.api.persistence.entity.Order;

public interface OrderService {
    void saveOrder(Order order);
    Order getCurrentOrder();

    void desabledOrder(Long idOrder);
}