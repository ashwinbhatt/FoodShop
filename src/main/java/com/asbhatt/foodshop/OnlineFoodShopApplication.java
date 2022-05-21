package com.asbhatt.foodshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OnlineFoodShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodShopApplication.class, args);
	}

}
