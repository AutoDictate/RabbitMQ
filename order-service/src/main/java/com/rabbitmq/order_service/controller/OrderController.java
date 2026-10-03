package com.rabbitmq.order_service.controller;

import com.rabbitmq.order_service.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public String createOrder() {

        orderService.createOrder();

        return "Order created";
    }
}
