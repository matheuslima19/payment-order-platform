package com.matheus.orderservice.application.service;

import com.matheus.orderservice.application.port.in.CreateOrderCommand;
import com.matheus.orderservice.application.port.in.CreateOrderUseCase;
import com.matheus.orderservice.application.port.in.FindOrderUseCase;
import com.matheus.orderservice.application.port.out.OrderRepositoryPort;
import com.matheus.orderservice.domain.exception.OrderNotFoundException;
import com.matheus.orderservice.domain.model.Order;

public class OrderService implements CreateOrderUseCase, FindOrderUseCase {

    private final OrderRepositoryPort orderRepositoryPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order create(CreateOrderCommand command) {
        Order order = Order.create(command.customerId(), command.amount());
        return orderRepositoryPort.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepositoryPort.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }
}
