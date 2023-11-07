package com.make.pizza.api.persistence.repository;

import com.make.pizza.api.persistence.entity.SystemParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemParameterRepository extends JpaRepository<SystemParameter, Long> {
    Optional<SystemParameter> findByName(String parameterName);
}
