package com.banhodepote.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banhodepote.api.model.Items;
import com.banhodepote.api.model.Order;
import com.banhodepote.api.model.Waiter;
import com.banhodepote.api.repository.OrderRepository;
import com.banhodepote.api.repository.WaiterRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WaiterRepository waiterRepository;




    public Order criarPedido(List<Items> items, Long waiterId) {
        Waiter waiter = waiterRepository.findById((long) 1).orElseThrow(() -> new IllegalArgumentException("Waiter not found"));
        Order order = new Order();
        order.setWaiter(waiter);
        order.setItems(items);
        orderRepository.save(order);

        return order;
        
    }
}
