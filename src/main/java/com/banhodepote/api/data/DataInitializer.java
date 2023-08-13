package com.banhodepote.api.data;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.banhodepote.api.dto.ItemDTO;
import com.banhodepote.api.dto.UserDTO;
import com.banhodepote.api.model.Items;
import com.banhodepote.api.model.Waiter;
import com.banhodepote.api.repository.ItemsRepository;
import com.banhodepote.api.repository.OrderRepository;
import com.banhodepote.api.repository.WaiterRepository;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private WaiterRepository waiterRepository;
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        if (waiterRepository.count() == 0 && itemsRepository.count() == 0) {

        Waiter waiter1 = new Waiter(new UserDTO("waiter1", "Otávio Santos", "waiter-1@hotmail.com", "dsfsdfds"));
        Waiter waiter2 = new Waiter(new UserDTO("waiter2", "Davi Azevedo", "waiter-2@hotmail.com", "sdfdsfdsf"));
        Waiter waiter3 = new Waiter(new UserDTO("waiter3", "Murilo Oliveira", "waiter-3@hotmail.com", "dsfsdfsdfsd"));
        
        waiterRepository.saveAll(Arrays.asList(waiter1, waiter2, waiter3));

        Items item1 = new Items(new ItemDTO("Pizza", 70.00,1));
        Items item2 = new Items(new ItemDTO("Hamburguer", 15.00,1));
        Items item3 = new Items(new ItemDTO("Batata Frita", 5.00,2));

        itemsRepository.saveAll(Arrays.asList(item1, item2, item3));
        }
    }
}