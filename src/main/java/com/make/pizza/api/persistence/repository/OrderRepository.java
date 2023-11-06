package com.make.pizza.api.persistence.repository;

import com.make.pizza.api.persistence.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {
    @Query("Select o from UserOrder o where o.user.id=?1 and o.enabled = true")
    List<UserOrder> findByUserAndEnabledTrue(Long idUsuario);

    @Modifying
    @Query("update UserOrder o set o.enabled = false where o.id = ?1")
    void desabledOrder(Long idOrder);
}