package com.springboot.springrabbitmqconsumer.consumer;

import com.springboot.springrabbitmqconsumer.ItemService;
import com.springboot.springrabbitmqconsumer.entity.ItemEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
@Slf4j
public class ItemConsumer {

    @Autowired
    private ItemService itemService;

    @RabbitListener(queues = Constant.QUEUE_CREATE)
    public void listenerItemCreate(Item item) {
        log.info("Messages Consumed from CREATE " + item.getItemId());
        ItemEntity itemEntity = itemService.handleCreate(item);
        if (itemEntity != null) {
            log.info("Item created successfully : " + itemEntity.getItemId());
        }
    }

    @RabbitListener(queues = Constant.QUEUE_UPDATE)
    public void listenerItemUpdate(Item item) {
        log.info("Messages Consumed from UPDATE " + item.getItemId());
        ItemEntity itemEntity = itemService.handleUpdate(item);
        if (itemEntity != null) {
            log.info("Item updated successfully : " + itemEntity.getItemId());
        }
    }

    @RabbitListener(queues = Constant.QUEUE_DELETE)
    public void listenerItemDelete(Item item) {
        log.info("Messages Consumed from DELETE " + item.getItemId());
        itemService.handleDelete(item);
        log.info("Item deleted successfully : " + item.getItemId());

    }
}
