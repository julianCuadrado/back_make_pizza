package com.make.pizza.api.persistence.repository;

import com.make.pizza.api.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("Select o from Order o where o.user.id=?1 and o.enabled = true")
    List<Order> findByUserAndEnabledTrue(Long idUsuario);

    @Modifying
    @Query("update Order o set o.enabled = false where o.id = ?1")
    void desabledOrder(Long idOrder);
}