package com.banhodepote.api.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhodepote.api.enums.CategoryFood;
import com.banhodepote.api.model.Items;
import com.banhodepote.api.model.Order;
import com.banhodepote.api.repository.ItemsRepository;
import com.banhodepote.api.repository.OrderRepository;
import com.banhodepote.api.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ItemsRepository itemRepository;

    @GetMapping
    public List<Order> allOrders(){
        
        List<Order> all = repository.findAll(); //returns empty
        return all;
    }

    @PostMapping
    public List<Items> createOrder(){
        List<Items> items = new ArrayList<>();
        Items item1 = new Items();
        item1.setItemName("Item 1");
        item1.setCategoryFood(CategoryFood.PRATO);
        item1.setPrice(10);
        Items item2 = new Items();
        item2.setItemName("Item 2");
        item2.setCategoryFood(CategoryFood.PRATO);
        item2.setPrice(15);

        items.add(item1);
        items.add(item2);
        Order order = service.criarPedido(items, Long.valueOf(1) );


        return itemRepository.findAll();

    }


}
