package com.mahin.pizzadelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.core.DatabaseClient;
import java.util.List;

@SpringBootApplication
public class PizzadeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzadeliveryApplication.class, args);
	}



}
