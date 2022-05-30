package com.asbhatt.foodshop.databasemodels;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("OrderDish")
public class OrderDish {

    @MongoId
    private String id;

    @DBRef
    private Dish dishType;

    @Field
    private Integer quantity;

    @Field
    private OrderDishState state;

    public OrderDishState getState() {
        return state;
    }

    public void setState(OrderDishState state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dish getDishType() {
        return dishType;
    }

    public void setDishType(Dish dishType) {
        this.dishType = dishType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderDish (){
        this.state= OrderDishState.UNINITIALIZED;
    }
}
