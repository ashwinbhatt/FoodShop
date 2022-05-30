package com.asbhatt.foodshop.business.kitchenprocesses;

import com.asbhatt.foodshop.databasemodels.OrderDish;
import com.asbhatt.foodshop.databasemodels.OrderDishState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class KitchenQueue {

    @Value("${App.KitchenQueue.MAXSIZE}")
    private Integer MAX_KITCHED_QUEUE_SIZE;

    private Queue<OrderDish> preparationQueue;
    private HashMap<String, OrderDish> orderDishesIdsMap;

    public KitchenQueue() {
        this.preparationQueue = new ArrayDeque<>();
        this.orderDishesIdsMap= new HashMap();
    }

    public boolean containsOrderDishes(OrderDish orderDish){
        return orderDishesIdsMap.containsKey(orderDish.getId());
    }

    public OrderDish addItem(OrderDish orderDish){
        if(this.orderDishesIdsMap.containsKey(orderDish.getId()) || this.preparationQueue.size() >= this.MAX_KITCHED_QUEUE_SIZE){
            return orderDish;
        }
        orderDish.setState(OrderDishState.PREPARING);
        this.preparationQueue.add(orderDish);
        // TODO : Later second index represent Queue Position
        this.orderDishesIdsMap.put(orderDish.getId(), orderDish);
        return orderDish;
    }

    public OrderDish getItem(){
        if(this.preparationQueue.isEmpty()) return null;
        OrderDish orderDish = this.preparationQueue.poll();
        this.orderDishesIdsMap.remove((orderDish.getId()));
        orderDish.setState(OrderDishState.PREPARED);
        return orderDish;
    }

    @Override
    public String toString() {
        return "KitchenQueue{" +
                "preparationQueue_Size=" + preparationQueue.size() +
                ", MAX_KITCHED_QUEUE_SIZE=" + MAX_KITCHED_QUEUE_SIZE +
                '}';
    }
}
