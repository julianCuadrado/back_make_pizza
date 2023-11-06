package com.make.pizza.api.persistence.entity;

import com.make.pizza.api.persistence.entity.pay.PayPalOrderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bills")
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateBill;
    private Double total;
    @ManyToOne(cascade = {})
    @JoinColumn(name = "paypal_order_id", referencedColumnName = "id")
    private PayPalOrderEntity payPalOrder;
    @Column(name = "full_name_client")
    private String fullNameClient;
    @ManyToOne(cascade = {})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private Double longitude;
    private Double latitude;
    @Column(name = "address_client")
    private String addressClient;
    @OneToMany(mappedBy = "billEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemBill> items;
    private boolean state;

}