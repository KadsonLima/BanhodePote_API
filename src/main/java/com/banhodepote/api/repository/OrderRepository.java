package com.banhodepote.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.banhodepote.api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findAll();

}