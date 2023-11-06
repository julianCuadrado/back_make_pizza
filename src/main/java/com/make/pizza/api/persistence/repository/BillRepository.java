package com.make.pizza.api.persistence.repository;

import com.make.pizza.api.persistence.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    List<BillEntity> getByStateTrue();
}
