package com.matheus.orderservice.adapter.in.web;

import com.matheus.orderservice.adapter.in.web.dto.CreateOrderRequest;
import com.matheus.orderservice.adapter.in.web.dto.OrderResponse;
import com.matheus.orderservice.application.port.in.CreateOrderCommand;
import com.matheus.orderservice.application.port.in.CreateOrderUseCase;
import com.matheus.orderservice.application.port.in.FindOrderUseCase;
import com.matheus.orderservice.domain.model.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders", description = "Operacoes para criacao e consulta de pedidos")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final FindOrderUseCase findOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, FindOrderUseCase findOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.findOrderUseCase = findOrderUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar pedido", description = "Cria um pedido com status inicial CREATED.")
    public OrderResponse create(@RequestBody @Valid CreateOrderRequest request) {
        Order order = createOrderUseCase.create(new CreateOrderCommand(request.customerId(), request.amount()));
        return toResponse(order);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pedido por ID", description = "Retorna os dados de um pedido existente.")
    public OrderResponse findById(@PathVariable Long id) {
        Order order = findOrderUseCase.findById(id);
        return toResponse(order);
    }

    private OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getAmount(),
                order.getStatus().name(),
                order.getCreatedAt()
        );
    }
}
