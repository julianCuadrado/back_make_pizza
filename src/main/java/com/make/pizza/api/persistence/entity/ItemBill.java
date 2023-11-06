package com.make.pizza.api.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items_bill")
public class ItemBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private String description;
    @Column(name = "unit_value")
    private Double unitValue;
    @Column(name = "total_value")
    private Double totalValue;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonIgnore
    private BillEntity billEntity;
}