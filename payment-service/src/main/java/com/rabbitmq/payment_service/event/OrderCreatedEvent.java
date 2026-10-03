package com.rabbitmq.payment_service.event;

public class OrderCreatedEvent {

    private Long orderId;
    private Long customerId;
    private Double amount;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(Long orderId, Long customerId, Double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Double getAmount() {
        return amount;
    }
}
