package com.asbhatt.foodshop;

import com.asbhatt.foodshop.business.kitchenprocesses.KitchenQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OnlineFoodShopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnlineFoodShopApplication.class, args);
	}

}
