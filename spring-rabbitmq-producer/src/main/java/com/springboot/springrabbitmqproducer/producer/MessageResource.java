package com.springboot.springrabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResource {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/publish/create")
    public ResponseEntity<String> create(@RequestBody Item item) {
        try {
            rabbitTemplate.convertAndSend(Constant.ITEM_EXCHANGE, Constant.ROUTING_KEY_CREATE, item);
            return ResponseEntity.ok("Message published with routing key Create");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Error which publishing with routing key Create");
        }
    }

    @PostMapping("/publish/update")
    public ResponseEntity<String> update(@RequestBody Item item) {
        try {
            rabbitTemplate.convertAndSend(Constant.ITEM_EXCHANGE, Constant.ROUTING_KEY_UPDATE, item);
            return ResponseEntity.ok("Message published with routing key Update");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Error which publishing with routing key Update");
        }
    }
    @PostMapping("/publish/delete")
    public ResponseEntity<String> delete(@RequestBody Item item) {
        try {
            rabbitTemplate.convertAndSend(Constant.ITEM_EXCHANGE, Constant.ROUTING_KEY_DELETE, item);
            return ResponseEntity.ok("Message published with routing key Delete");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Error which publishing with routing key Delete");
        }
    }
}
