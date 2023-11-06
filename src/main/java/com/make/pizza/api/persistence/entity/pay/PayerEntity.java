package com.make.pizza.api.persistence.entity.pay;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payer")
public class PayerEntity {

    @Id
    @Column(name = "payer_id")
    private String payerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private NameEntity name;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "country_code")
    private String countryCode;
}