package com.mahin.pizzadelivery.repository;

import com.mahin.pizzadelivery.model.Pizza;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PizzaRepository extends ReactiveCrudRepository <Pizza, Long> {

}
