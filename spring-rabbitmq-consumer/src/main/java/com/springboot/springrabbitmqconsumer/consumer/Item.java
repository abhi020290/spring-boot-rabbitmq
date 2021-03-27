package com.springboot.springrabbitmqconsumer.consumer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    private String itemId;
    private String itemCategory;
    private String itemQuantity;
    private String itemDescription;
}
