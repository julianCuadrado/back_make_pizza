package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "capture")
@Getter
@Setter
public class CaptureEntity {

    @Id
    private String id;

    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_id", referencedColumnName = "id")
    private AmountEntity amount;

    @Column(name = "final_capture")
    private boolean finalCapture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_protection_id", referencedColumnName = "id")
    private SellerProtectionEntity sellerProtection;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payments_id", referencedColumnName = "id")
    private PaymentsEntity payments;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;
}