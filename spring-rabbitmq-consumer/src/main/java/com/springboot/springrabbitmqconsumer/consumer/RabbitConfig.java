package com.springboot.springrabbitmqconsumer.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public static Queue queueCreate() {
        return new Queue(Constant.QUEUE_CREATE);
    }

    @Bean
    public static Queue queueUpdate() {
        return new Queue(Constant.QUEUE_UPDATE);
    }

    @Bean
    public static Queue queueDelete() {
        return new Queue(Constant.QUEUE_DELETE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Constant.ITEM_EXCHANGE);
    }

    @Bean
    public Binding bindingCreate(TopicExchange exchange, Queue queueCreate) {
        return BindingBuilder
                .bind(queueCreate)
                .to(exchange)
                .with(Constant.ROUTING_KEY_CREATE);
    }

    @Bean
    public Binding bindingUpdate(TopicExchange exchange, Queue queueUpdate) {
        return BindingBuilder
                .bind(queueUpdate)
                .to(exchange)
                .with(Constant.ROUTING_KEY_UPDATE);
    }

    @Bean
    public Binding bindingDelete(TopicExchange exchange, Queue queueDelete) {
        return BindingBuilder
                .bind(queueDelete)
                .to(exchange)
                .with(Constant.ROUTING_KEY_DELETE);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }


}
