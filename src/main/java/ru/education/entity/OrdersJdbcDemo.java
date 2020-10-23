package ru.education.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrdersJdbcDemo {
    private int id;
    private Date date;
    private long price;
    private int quantity;
    private String customer;
    private Integer product;

    public OrdersJdbcDemo(int id, Date date, long price, int quantity, String customer, Integer product) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
    }
}
