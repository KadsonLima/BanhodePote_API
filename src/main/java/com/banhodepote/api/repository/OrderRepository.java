package com.banhodepote.api.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banhodepote.api.model.Order;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;

import com.banhodepote.api.enums.Status;


public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findAll();

    Order deleteById(int id);

    Optional<Order> findById(Long id);

    Optional<Order> findByWaiterId(int id);

    Optional<Order> findByWaiterIdAndStatus(int waiterId, Status status);

    @Modifying
    @Query("UPDATE Order o SET o.status = :newStatus WHERE o.id = :orderId AND o.status = 'OPEN'")
    void updateStatusById(Long orderId, Status newStatus);



}
