package com.banhodepote.api.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.banhodepote.api.model.Items;
import com.banhodepote.api.model.Order;
import com.banhodepote.api.model.Waiter;
import com.banhodepote.api.repository.ItemsRepository;
import com.banhodepote.api.repository.OrderRepository;
import com.banhodepote.api.repository.WaiterRepository;
import com.banhodepote.exception.ApiException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private WaiterRepository waiterRepository;

    public Order criarPedido(List<Long> items, int waiterId) throws ApiException  {

     
            List<Items> listItems = itemsRepository.findAllById(items);
    
            if (listItems.size() != items.size()) {
                throw new ApiException (HttpStatus.INSUFFICIENT_STORAGE, "Alguns itens da lista estão faltando!");
            }
    
            Waiter waiter = waiterRepository.findById(waiterId).orElse(null);
    
            if (waiter == null) {
                throw new ApiException(HttpStatus.NOT_FOUND, "Garçom não encontrado");
            }
    
            Order order = new Order();
            order.setWaiter(waiter);
            order.setItems(listItems);
            orderRepository.save(order);
    
            return order;
      

    }

    public void deleteOrder(int id) throws NotFoundException {
        if (!orderRepository.existsById(id)) {
            throw new NotFoundException();
        }

        orderRepository.deleteById(id);

    }

    public Order updateOrder(int id, Order order) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));

        existingOrder.setItems(null);
        return order;

    }
}
