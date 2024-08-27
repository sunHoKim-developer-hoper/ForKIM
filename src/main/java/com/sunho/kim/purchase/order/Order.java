package com.sunho.kim.purchase.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public  int calculatePrice(){
        return itemPrice - discountPrice;
    }


}
