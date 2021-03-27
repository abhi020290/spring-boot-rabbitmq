package com.springboot.springrabbitmqproducer.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String itemId;
    private String itemCategory;
    private String itemQuantity;
    private String itemDescription;
}
