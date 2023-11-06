package com.make.pizza.api.controller;

import com.make.pizza.api.dto.PayDTO;
import com.make.pizza.api.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paypal")
public class PayPalOrderController {

    private final PayService payService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PayDTO payDTO) {
        payService.processPay(payDTO);
        return ResponseEntity.ok(Map.of("mensaje", "Exitoso"));
    }
}