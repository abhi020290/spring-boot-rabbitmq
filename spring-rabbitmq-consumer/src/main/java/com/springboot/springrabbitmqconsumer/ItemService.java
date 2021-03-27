package com.springboot.springrabbitmqconsumer;

import com.springboot.springrabbitmqconsumer.consumer.Item;
import com.springboot.springrabbitmqconsumer.entity.ItemEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemEntity handleCreate(Item item){
        ItemEntity itemEntity = new ItemEntity();
        BeanUtils.copyProperties(item,itemEntity);
        return itemRepository.save(itemEntity);
    }

    public ItemEntity handleUpdate(Item item){
        ItemEntity itemEntity = new ItemEntity();
        BeanUtils.copyProperties(item,itemEntity);
        return itemRepository.save(itemEntity);
    }

    public void handleDelete(Item item){
        ItemEntity itemEntity = new ItemEntity();
        BeanUtils.copyProperties(item,itemEntity);
        itemRepository.delete(itemEntity);
    }

    public List<ItemEntity> findAllItem() {
        return itemRepository.findAll();
    }
}
