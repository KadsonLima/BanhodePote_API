package com.banhodepote.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhodepote.api.dto.ItemDTO;
import com.banhodepote.api.model.Items;
import com.banhodepote.api.repository.ItemsRepository;


@RestController
@RequestMapping("/items")
public class ItemController {

    // @Autowired
    // private OrderService service;

    @Autowired
    private ItemsRepository repository;

    @GetMapping
    public List<Items> allItems(){
        return repository.findAll();
    }

    @GetMapping("/{categoryId}")
    public Optional<Items> getItemsByCategory(@PathVariable int categoryId){

        return repository.findById((long)categoryId);

    }

    @PostMapping
    public Items createItem(@RequestBody ItemDTO data){
        Items item = new Items(data);

        return repository.save(item);

    }


}
