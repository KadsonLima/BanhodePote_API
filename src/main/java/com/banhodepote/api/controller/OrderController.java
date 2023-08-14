package com.banhodepote.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.banhodepote.api.model.Order;
import com.banhodepote.api.repository.OrderRepository;
import com.banhodepote.api.services.OrderService;
import com.banhodepote.exception.ApiException;

import jakarta.transaction.Transactional;

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
    public List<Order> allOrders() {

        List<Order> all = repository.findAll(); // returns empty
        return all;
    }


    @PostMapping("/{mesa}/{waiterId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createOrder(
            @RequestBody Map<String, List<Long>> requestBody,
            @PathVariable("mesa") int mesa,
            @PathVariable("waiterId") int waiterId) {

        List<Long> items = requestBody.get("items");

        try {
            Order order = service.criarPedido(items, waiterId, mesa);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatus());
        }

    }


    @PatchMapping("/{status}/{id}")
    @Transactional
    public ResponseEntity<?> updateStatusOrder(@PathVariable("id") Long id, @PathVariable("status") String status) {
        try {
            Order newOrder = service.updateStatusById(id, status);
            return new ResponseEntity<>(newOrder, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatus());
        }
    }

    @PatchMapping("/updateListOrders")
    @Transactional
    public ResponseEntity<?> updateListOrders(@RequestBody List<Long> listOrder) {
        try {
            List<Order> newOrder = service.receivedListOrders(listOrder);
            return new ResponseEntity<>(newOrder, HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatus());
        }
    }

}
