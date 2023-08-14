package com.banhodepote.api.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.banhodepote.api.enums.Status;
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

    public Order criarPedido(List<Long> items, int waiterId, int mesa) throws ApiException {

        Waiter waiter = waiterRepository.findById(waiterId).orElse(null);

        if (waiter == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Garçom não encontrado");
        }

        Optional<Order> existingOrder = orderRepository.findByWaiterIdAndStatus(waiterId, Status.OPEN);

        if (existingOrder.isPresent()) {
            throw new ApiException(HttpStatus.CONFLICT, "Esse Garçom já está com uma Mesa!");
        }
        

        List<Items> itemList = itemsRepository.findAllById(items);
        Set<Items> setItems = new HashSet<>(itemList);

        if (setItems.size() != items.size()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Alguns itens da lista não existem!");
        }

        Order order = new Order(waiter, setItems, mesa);
        orderRepository.save(order);

        return order;
    }


    public Order updateStatusById(Long id, String newStatus) {
        Optional<Order> existingOrder = orderRepository.findById(id);

        if (!existingOrder.isPresent()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Pedido não Encontrado!");
        }

        Order order = existingOrder.get();

        if(order.getStatus() != Status.OPEN){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Pedido não está Aberto!");
        }

        if(newStatus.equals("received")){
            order.setStatus(Status.DELIVERED);
        }else if(newStatus.equals("cancel")){
            order.setStatus(Status.CANCELED);
        }else{
            throw new ApiException(HttpStatus.METHOD_NOT_ALLOWED, "Status Não Permitido! " + newStatus);
        }
        
        orderRepository.save(order);
        return order;
    }

    public List<Order> receivedListOrders(List<Long> listOrders){

        List<Order> orders = orderRepository.findAll();

        for (Order order : orders) {
            Long id = order.getId();
            if(listOrders.contains(id) && order.getStatus().equals(Status.OPEN)){
                orderRepository.updateStatusById(id, Status.DELIVERED);
            }
        }

        
        return orderRepository.findAllById(listOrders);
        
    }

}


