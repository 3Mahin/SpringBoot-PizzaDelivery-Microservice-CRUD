package com.mahin.pizzadelivery.service;

import com.mahin.pizzadelivery.model.Pizza;
import com.mahin.pizzadelivery.repository.PizzaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PizzaService {
    private final PizzaRepository repository;

    public PizzaService(PizzaRepository repository){
        this.repository = repository;

    }

    public Flux<Pizza> findAll(){
        return repository.findAll();
    }

    public Mono<Pizza> findById(Long id){
        return repository.findById(id);
    }

    public Mono<Pizza> create(Pizza pizza){
        pizza.setId(null);
        return repository.save(pizza);
    }

    public Mono<Pizza> update(Long id, Pizza incoming){
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setName(incoming.getName());
                    existing.setPrice(incoming.getPrice());
                    return repository.save(existing);
                });
    }

    public Mono<Void> delete(Long id){
        return repository.deleteById(id);
    }
}
