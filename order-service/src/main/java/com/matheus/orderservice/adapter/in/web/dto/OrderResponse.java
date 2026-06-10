package com.matheus.orderservice.adapter.in.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        String customerId,
        BigDecimal amount,
        String status,
        LocalDateTime createdAt
) {
}
