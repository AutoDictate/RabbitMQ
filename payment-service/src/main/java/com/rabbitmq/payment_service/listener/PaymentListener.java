package com.rabbitmq.payment_service.listener;

import com.rabbitmq.payment_service.config.RabbitMQConfig;
import com.rabbitmq.payment_service.event.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void processPayment(OrderCreatedEvent event) {

        System.out.println("Received ORDER_CREATED event");

        System.out.println("Order ID: " + event.getOrderId());

        System.out.println("Amount: " + event.getAmount());

        System.out.println("Processing payment...");
    }
}