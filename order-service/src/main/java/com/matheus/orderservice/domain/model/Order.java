package com.matheus.orderservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private final Long id;
    private final String customerId;
    private final BigDecimal amount;
    private final OrderStatus status;
    private final LocalDateTime createdAt;

    private Order(Long id, String customerId, BigDecimal amount, OrderStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static Order create(String customerId, BigDecimal amount) {
        return new Order(null, customerId, amount, OrderStatus.CREATED, LocalDateTime.now());
    }

    public static Order restore(Long id, String customerId, BigDecimal amount, OrderStatus status, LocalDateTime createdAt) {
        return new Order(id, customerId, amount, status, createdAt);
    }

    public Long getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
