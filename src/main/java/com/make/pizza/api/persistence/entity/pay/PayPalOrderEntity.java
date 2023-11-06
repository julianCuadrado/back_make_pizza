package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pay_pal_order")
public class PayPalOrderEntity {

    @Id
    private String id;

    private String intent;

    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payPalOrder")
    private List<PurchaseUnitEntity> purchaseUnits;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id", referencedColumnName = "payer_id")
    private PayerEntity payer;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payPalOrder")
    private List<LinkEntity> links;
}