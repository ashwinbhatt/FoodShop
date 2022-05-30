package com.asbhatt.foodshop.databasemodels;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("Dish")
public class Dish {

    @MongoId
    private String id;

    @Field("Name")
    private String name;

    @Field(name = "Price")
    private Integer cost;

    @Field(name = "ExpectedLife")
    private Integer expLife;

    @Field(name = "PreparationDuration")
    private Integer prepTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getExpLife() {
        return expLife;
    }

    public void setExpLife(int expLife) {
        this.expLife = expLife;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

}
