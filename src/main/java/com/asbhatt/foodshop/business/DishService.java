package com.asbhatt.foodshop.business;

import com.asbhatt.foodshop.databasemodels.Dish;
import com.asbhatt.foodshop.databasemodels.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDish(Dish searchDish){
        List<Dish> searchRes= this.dishRepository.findAll();

        return searchRes.stream()
                .filter( dish -> dish.getName().matches(searchDish.getName()))
                .collect(Collectors.toList());
    }

    public Dish addDish(Dish dish){
        return this.dishRepository.save(dish);
    }

    public boolean removeDish(String id){
        if(this.dishRepository.findById(id) != null){
            return false;
        }
        this.dishRepository.deleteById(id);
        return true;
    }

    public boolean updateDish(String id, Dish dish) {
        if(this.dishRepository.findById(id) == null) return false;
        dish.setId(id);
        this.dishRepository.save(dish);
        return true;
    }

}
