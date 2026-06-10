package com.matheus.orderservice.application.port.in;

import com.matheus.orderservice.domain.model.Order;

public interface CreateOrderUseCase {
    Order create(CreateOrderCommand command);
}
