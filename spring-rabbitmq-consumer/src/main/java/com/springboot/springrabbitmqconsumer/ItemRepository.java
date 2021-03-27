package com.springboot.springrabbitmqconsumer;

import com.springboot.springrabbitmqconsumer.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,String> {
}
