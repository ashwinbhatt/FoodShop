package com.asbhatt.foodshop.databasemodels;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("Customer")
public class Customer {

    @MongoId
    private String id;

    @Field("FirstName")
    private String firstName;

    @Field("LastName")
    private String lastName;

    @Field("PhoneNumber")
    private String phoneNo;

}
