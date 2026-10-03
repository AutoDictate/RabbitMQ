package com.rabbitmq.notification_service.listener;

import com.rabbitmq.notification_service.config.RabbitMQConfig;
import com.rabbitmq.notification_service.event.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleOrderCreated(OrderCreatedEvent event) {

        System.out.println("================================");
        System.out.println("📧 Notification Service");
        System.out.println("Received ORDER_CREATED event");
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Customer ID: " + event.getCustomerId());
        System.out.println("Amount: " + event.getAmount());
        System.out.println("Sending order confirmation notification...");
        System.out.println("================================");
    }
}
