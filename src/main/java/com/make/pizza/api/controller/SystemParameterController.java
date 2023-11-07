package com.make.pizza.api.controller;

import com.make.pizza.api.service.SystemParameterService;
import com.make.pizza.api.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/system-parameters")
public class SystemParameterController {

    private final SystemParameterService systemParameterService;

    @GetMapping("/configuration-map-shop")
    public ResponseEntity<Map<String, String>> getConfigMapShop() {
        String parameterValue = systemParameterService.getParameterValue(Constant.PARAMETER_CONFIG_MAP_SHOP);
        return ResponseEntity.ok(Map.of("valor", parameterValue));
    }

    @GetMapping("/price-minute-delivery")
    public ResponseEntity<Map<String, String>> getValuePriceMinuteDelivery() {
        String parameterValue = systemParameterService.getParameterValue(Constant.PARAMETER_PRICE_MINUTE_DELIVERY);
        return ResponseEntity.ok(Map.of("valor", parameterValue));
    }
}