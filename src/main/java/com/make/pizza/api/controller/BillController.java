package com.make.pizza.api.controller;

import com.make.pizza.api.dto.BillDTO;
import com.make.pizza.api.persistence.entity.BillEntity;
import com.make.pizza.api.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    @GetMapping
    public List<BillDTO> getAll() {
        return billService.getAllActive();
    }
}