package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "link")
public class LinkEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String href;

    private String rel;

    private String method;
    @ManyToOne
    @JoinColumn(name = "payPal_order_id", referencedColumnName = "id")
    private PayPalOrderEntity payPalOrder;
}