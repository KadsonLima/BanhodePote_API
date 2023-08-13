package com.banhodepote.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhodepote.api.dto.UserDTO;
import com.banhodepote.api.model.Items;
import com.banhodepote.api.model.Order;
import com.banhodepote.api.model.Waiter;
import com.banhodepote.api.repository.OrderRepository;
import com.banhodepote.api.repository.WaiterRepository;
import com.banhodepote.api.services.OrderService;

@RestController
@RequestMapping("/waiter")
public class WaiterController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private WaiterRepository repository;

    @GetMapping
    public List<Waiter> allWaiters(){
        return repository.findAll();
    }

    @PostMapping
    public void subscribeWaiter(@RequestBody UserDTO req){
        repository.save(new Waiter(req));
    }

    @GetMapping("/{name}")
    public List<Waiter> findWaiter(@PathVariable String name){

        return repository.findAllByName(name);
    } 

    
}
