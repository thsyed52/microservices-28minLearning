package com.fruitprices.fruit_totalprice_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class FruitTotalpriceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitTotalpriceServiceApplication.class, args);
	}

}
