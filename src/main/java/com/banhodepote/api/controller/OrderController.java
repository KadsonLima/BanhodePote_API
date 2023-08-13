package com.banhodepote.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banhodepote.api.model.Order;
import com.banhodepote.api.repository.ItemsRepository;
import com.banhodepote.api.repository.OrderRepository;
import com.banhodepote.api.services.OrderService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository repository;


    @GetMapping
    public List<Order> allOrders(){
        
        List<Order> all = repository.findAll(); //returns empty
        return all;
    }

    @DeleteMapping(value="/{id}")
    public void deleteOrder(@PathVariable int id) throws NotFoundException{

        service.deleteOrder(id);

    }

    @PutMapping(value="/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
        
        Order newOrder = service.updateOrder(id, order);
        
        return newOrder;
    }

    @PostMapping("/{mesa}/{waiterId}")
    public Order createOrder(
        @RequestBody Map<String, List<Long>> requestBody,
        @PathVariable int mesa,
        @PathVariable int waiterId) {

        List<Long> items = requestBody.get("items");
        System.out.println(items);
        Order order = service.criarPedido(items, waiterId );

        return order;

    }


}
