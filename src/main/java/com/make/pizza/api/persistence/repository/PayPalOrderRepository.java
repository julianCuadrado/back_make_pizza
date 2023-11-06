package com.make.pizza.api.persistence.repository;

import com.make.pizza.api.persistence.entity.pay.PayPalOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayPalOrderRepository extends JpaRepository<PayPalOrderEntity, String> {
}