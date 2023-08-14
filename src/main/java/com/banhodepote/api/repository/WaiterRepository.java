package com.banhodepote.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banhodepote.api.model.Waiter;

public interface WaiterRepository extends JpaRepository<Waiter, Integer> {
    
    List<Waiter> findAllByName(String name);


}
