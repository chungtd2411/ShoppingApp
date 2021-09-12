package com.shopping.model;

import lombok.Data;

@Data
public class JoinOrder {

    private int orderId;
    private String username;
    private String productName;
    private int price;
    private int number;
    private int sum;

    public JoinOrder(int orderId, String username, String productName, int price, int number) {
        this.orderId = orderId;
        this.username = username;
        this.productName = productName;
        this.price = price;
        this.number = number;
    }

    public int getSum() {
        return price * number;
    }
}
