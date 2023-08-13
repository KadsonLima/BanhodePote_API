package com.banhodepote.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banhodepote.api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    List<Order> findAll();

    Order deleteById(int id);


}
