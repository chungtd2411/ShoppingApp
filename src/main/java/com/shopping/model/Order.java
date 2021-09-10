package com.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_test")
@Data
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "uid")
    private int userId;

    @Column(name = "productid")
    private int productId;

    @Column(name = "number")
    private int quantity;

}
