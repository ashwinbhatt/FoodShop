package com.asbhatt.foodshop.databasemodels;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Collection;

@Document("Order")
public class Order {

    @MongoId
    private String id;

    @DBRef
    private Customer customer;

    @DBRef
    private Collection<OrderDish> items;

    @Field
    private OrderState state;

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState orderState) {
        this.state = orderState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<OrderDish> getItems() {
        return items;
    }

    public void setItems(Collection<OrderDish> items) {
        this.items = items;
    }

    public Order() {
        this.state= OrderState.NOT_PLACED;
    }
}
