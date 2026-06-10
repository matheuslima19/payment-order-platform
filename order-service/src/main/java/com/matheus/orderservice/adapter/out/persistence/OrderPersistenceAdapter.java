package com.matheus.orderservice.adapter.out.persistence;

import com.matheus.orderservice.application.port.out.OrderRepositoryPort;
import com.matheus.orderservice.domain.model.Order;
import com.matheus.orderservice.domain.model.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderPersistenceAdapter implements OrderRepositoryPort {

    private final SpringDataOrderRepository springDataOrderRepository;

    public OrderPersistenceAdapter(SpringDataOrderRepository springDataOrderRepository) {
        this.springDataOrderRepository = springDataOrderRepository;
    }

    @Override
    public Order save(Order order) {
        OrderJpaEntity entity = toEntity(order);
        OrderJpaEntity savedEntity = springDataOrderRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return springDataOrderRepository.findById(id)
                .map(this::toDomain);
    }

    private OrderJpaEntity toEntity(Order order) {
        OrderJpaEntity entity = new OrderJpaEntity();
        entity.setId(order.getId());
        entity.setCustomerId(order.getCustomerId());
        entity.setAmount(order.getAmount());
        entity.setStatus(order.getStatus().name());
        entity.setCreatedAt(order.getCreatedAt());
        return entity;
    }

    private Order toDomain(OrderJpaEntity entity) {
        return Order.restore(
                entity.getId(),
                entity.getCustomerId(),
                entity.getAmount(),
                OrderStatus.valueOf(entity.getStatus()),
                entity.getCreatedAt()
        );
    }
}
