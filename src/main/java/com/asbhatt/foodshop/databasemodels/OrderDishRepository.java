package com.asbhatt.foodshop.databasemodels;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDishRepository extends MongoRepository<OrderDish, String> {
}
