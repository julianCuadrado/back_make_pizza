package com.make.pizza.api.service.impl;

import com.make.pizza.api.persistence.entity.ItemOrder;
import com.make.pizza.api.persistence.entity.Order;
import com.make.pizza.api.persistence.entity.User;
import com.make.pizza.api.persistence.repository.OrderRepository;
import com.make.pizza.api.service.OrderService;
import com.make.pizza.api.service.auth.AuthenticationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AuthenticationService authenticationService;

    @Override
    public void saveOrder(Order order) {
        User user = authenticationService.findLoggedInUser();
        order.setUser(user);
        order.setDateOrder(LocalDateTime.now());
        order.setEnabled(true);
        for (ItemOrder item : order.getItems()) {
            item.setOrder(order);
        }
        orderRepository.save(order);
    }

    @Override
    public Order getCurrentOrder() {
        User user = authenticationService.findLoggedInUser();
        List<Order> orders = orderRepository.findByUserAndEnabledTrue(user.getId());
        if(orders.isEmpty()) {
            return null;
        }
        return orders.get(0);
    }

    @Transactional
    @Override
    public void desabledOrder(Long idOrder) {
        orderRepository.desabledOrder(idOrder);
    }
}
