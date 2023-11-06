package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "purchase_unit")
public class PurchaseUnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_id")
    private String referenceId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_id", referencedColumnName = "id")
    private AmountEntity amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payee_id", referencedColumnName = "merchant_id")
    private PayeeEntity payee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_id", referencedColumnName = "id")
    private ShippingEntity shipping;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payments_id", referencedColumnName = "id")
    private PaymentsEntity payments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payPal_order_id", referencedColumnName = "id")
    private PayPalOrderEntity payPalOrder;
}