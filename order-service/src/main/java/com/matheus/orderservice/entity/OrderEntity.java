package com.matheus.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;

    private BigDecimal amount;

    private String status;

    private LocalDateTime createdAt;

    public OrderEntity(String customerId, BigDecimal amount, String status) {
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }
}
