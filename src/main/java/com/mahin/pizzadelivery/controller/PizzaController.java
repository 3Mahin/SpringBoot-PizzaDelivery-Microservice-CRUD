package com.mahin.pizzadelivery.controller;

import com.mahin.pizzadelivery.model.Pizza;
import com.mahin.pizzadelivery.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Pizza> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Pizza>> getOne(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pizza> create(@RequestBody Pizza pizza){
        return service.create(pizza);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Pizza>> update(@PathVariable Long id, @RequestBody Pizza pizza){
        return service.update(id, pizza)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
