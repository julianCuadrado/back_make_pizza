package com.make.pizza.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateOrder;
    private Double longitude;
    private Double latitude;
    @OneToMany(mappedBy = "userOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemOrder> items = new ArrayList<>();
    private boolean enabled;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}