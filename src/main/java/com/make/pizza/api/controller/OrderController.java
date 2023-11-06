package com.make.pizza.api.controller;

import com.make.pizza.api.persistence.entity.UserOrder;
import com.make.pizza.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody UserOrder userOrder) {
        orderService.saveOrder(userOrder);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<UserOrder> getCurrentOrder() {
        return ResponseEntity.ok(orderService.getCurrentOrder());
    }

    @PutMapping
    public ResponseEntity<?> desabledOrder(@RequestParam Long idOrder) {
        orderService.desabledOrder(idOrder);
        return ResponseEntity.ok().build();
    }
}