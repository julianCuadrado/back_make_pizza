package com.make.pizza.api.service.impl;

import com.make.pizza.api.persistence.entity.ItemOrder;
import com.make.pizza.api.persistence.entity.UserOrder;
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
    public void saveOrder(UserOrder userOrder) {
        User user = authenticationService.findLoggedInUser();
        userOrder.setUser(user);
        userOrder.setDateOrder(LocalDateTime.now());
        userOrder.setEnabled(true);
        for (ItemOrder item : userOrder.getItems()) {
            item.setUserOrder(userOrder);
        }
        orderRepository.save(userOrder);
    }

    @Override
    public UserOrder getCurrentOrder() {
        User user = authenticationService.findLoggedInUser();
        List<UserOrder> userOrders = orderRepository.findByUserAndEnabledTrue(user.getId());
        if(userOrders.isEmpty()) {
            return null;
        }
        return userOrders.get(0);
    }

    @Transactional
    @Override
    public void desabledOrder(Long idOrder) {
        orderRepository.desabledOrder(idOrder);
    }
}
