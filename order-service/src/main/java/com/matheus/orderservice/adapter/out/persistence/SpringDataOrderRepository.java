package com.matheus.orderservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderRepository extends JpaRepository<OrderJpaEntity, Long> {
}
