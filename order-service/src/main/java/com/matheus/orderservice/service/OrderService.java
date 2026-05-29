package com.matheus.orderservice.service;

import com.matheus.orderservice.dto.CreateOrderRequest;
import com.matheus.orderservice.dto.OrderResponse;
import com.matheus.orderservice.entity.OrderEntity;
import com.matheus.orderservice.exception.OrderNotFoundException;
import com.matheus.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public OrderResponse create(CreateOrderRequest request){
        OrderEntity order = new OrderEntity(
                request.customerId(),
                request.amount(),
                "CREATED"
        );

        OrderEntity savedOrder = orderRepository.save(order);

        return toResponse(savedOrder);
    }

    public OrderResponse findById(Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        return toResponse(order);
    }

    private OrderResponse toResponse(OrderEntity order) {
        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getAmount(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }

}
