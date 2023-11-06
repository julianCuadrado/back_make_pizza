package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payee")
public class PayeeEntity {

    @Id
    @Column(name = "merchant_id")
    private String merchantId;
    @Column(name = "email_address")
    private String emailAddress;
}