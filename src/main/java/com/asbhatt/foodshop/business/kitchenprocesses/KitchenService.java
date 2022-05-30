package com.asbhatt.foodshop.business.kitchenprocesses;

import com.asbhatt.foodshop.databasemodels.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KitchenService {

    private final KitchenQueue kitchenQueue;
    private final OrderDishRepository orderDishRepository;
    private final OrderRepository orderRepository;

    public KitchenService(OrderDishRepository orderDishRepository, KitchenQueue kitchenQueue, OrderRepository orderRepository) {
        this.kitchenQueue = kitchenQueue;
        this.orderDishRepository = orderDishRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * Method to add new Ordered dish to kitchen preparation queue.
     * It only adds it queue queue permits else it checks if OrderedDish is present in Database
     * if not it adds entry to database.
     *
     * @param orderDish : Ordered dish which is requested to be added.
     */
    public void addDishToPrep(OrderDish orderDish){
        orderDish = kitchenQueue.addItem(orderDish);
        orderDishRepository.save(orderDish);
    }

    public void newOrder(Order order){
        order.setState(OrderState.IN_QUEUE);
        for(OrderDish orderDish : order.getItems()){
            this.addDishToPrep(orderDish);
        }
        orderRepository.save(order);
    }

    public OrderState checkOrderState(String orderId){
        Optional<Order> orderOptional= this.orderRepository.findById(orderId);
        if(!orderOptional.isPresent()){
            return OrderState.NO_SUCH_ORDER;
        }
        return orderOptional.get().getState();
    }

    public void updateOrder(Order order){
        for(OrderDish orderDish : order.getItems()){
            if(orderDish.getState().equals(OrderDishState.UNINITIALIZED)){
                addDishToPrep(orderDish);
            }
        }
    }


}
