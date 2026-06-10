package com.matheus.orderservice.adapter.config;

import com.matheus.orderservice.application.port.out.OrderRepositoryPort;
import com.matheus.orderservice.application.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBeanConfiguration {

    @Bean
    public OrderService orderService(OrderRepositoryPort orderRepositoryPort) {
        return new OrderService(orderRepositoryPort);
    }
}
