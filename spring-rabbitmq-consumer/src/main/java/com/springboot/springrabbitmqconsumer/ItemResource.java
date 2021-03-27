package com.springboot.springrabbitmqconsumer;

import com.springboot.springrabbitmqconsumer.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemResource {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<List<ItemEntity>> findAllItem() {
        return ResponseEntity.ok(itemService.findAllItem());
    }

}
