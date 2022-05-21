package com.asbhatt.foodshop.webservice;

import com.asbhatt.foodshop.business.DishService;
import com.asbhatt.foodshop.databasemodels.Dish;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DishController {

    private final DishService dishService;


    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @RequestMapping(path = "/dish", method = RequestMethod.GET)
    public List<Dish> getDish(@RequestBody Dish dish){
        return this.dishService.getAllDish(dish);
    }

    @RequestMapping(path = "/dish", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Dish setDish(@RequestBody Dish dish){
        return this.dishService.addDish(dish);
    }

    @RequestMapping(path = "/dish", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Dish createDish(@RequestBody Dish dish){
        return this.dishService.addDish(dish);
    }

    @RequestMapping(path = "/dish", method = RequestMethod.DELETE)
    public boolean deleteDish(@RequestParam(value = "dishId", required = true) String dishId){
        return this.dishService.removeDish(dishId);
    }

}
