package com.matheus.orderservice.application.port.out;

import com.matheus.orderservice.domain.model.Order;

import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order order);

    Optional<Order> findById(Long id);
}
