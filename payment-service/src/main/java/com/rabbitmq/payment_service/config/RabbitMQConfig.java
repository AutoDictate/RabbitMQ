package com.rabbitmq.payment_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "order.exchange";
    public static final String QUEUE_NAME = "payment.queue";
    public static final String ROUTING_KEY = "order.created";

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Binding paymentBinding(
            Queue paymentQueue,
            TopicExchange orderExchange) {

        return BindingBuilder
                .bind(paymentQueue)
                .to(orderExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }
}