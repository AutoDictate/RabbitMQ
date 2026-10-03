package com.rabbitmq.order_service.service;

import com.rabbitmq.order_service.config.RabbitMQConfig;
import com.rabbitmq.order_service.event.OrderCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final RabbitTemplate rabbitTemplate;

    public OrderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void createOrder() {
        OrderCreatedEvent event =
                new OrderCreatedEvent(
                        1001L,
                        501L,
                        2500.0
                );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                event
        );

        System.out.println("ORDER_CREATED event published");
    }
}
