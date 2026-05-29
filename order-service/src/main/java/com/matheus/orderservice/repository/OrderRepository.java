package com.matheus.orderservice.repository;

import com.matheus.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrderEntity, Long> {
}
