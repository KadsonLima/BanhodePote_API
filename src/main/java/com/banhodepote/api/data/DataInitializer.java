package com.banhodepote.api.data;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.banhodepote.api.dto.ItemDTO;
import com.banhodepote.api.dto.UserDTO;
import com.banhodepote.api.model.Waiter;
import com.banhodepote.api.repository.ItemsRepository;
import com.banhodepote.api.repository.WaiterRepository;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private WaiterRepository waiterRepository;
    // @Autowired
    // private ItemsRepository itemsRepository;
    // @Autowired
    // private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        Waiter waiter1 = new Waiter(new UserDTO("kadson1", "Kadson 1", "kadson-1@hotmail.com", "3205083f2"));
        Waiter waiter2 = new Waiter(new UserDTO("kadson2", "Kadson 2", "kadson-2@hotmail.com", "32050832"));
        Waiter waiter3 = new Waiter(new UserDTO("kadson3", "Kadson 3", "kadson-3@hotmail.com", "32050832"));
        
        waiterRepository.saveAll(Arrays.asList(waiter1, waiter2, waiter3));

        // CategoryFood category1 = new CategoryFood("PETISCO");
        // CategoryFood category2 = new CategoryFood("PRATO");
        // CategoryFood category3 = new CategoryFood("BEBIDAS");

        // categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        

        // Items item1 = new Items(new ItemDTO("Pizza", 70.00,1));
        // Items item2 = new Items(new ItemDTO("Hamburguer", 15.00,1));
        // Items item3 = new Items(new ItemDTO("Batata Frita", 5.00,2));

        // itemsRepository.saveAll(Arrays.asList(item1, item2, item3));
        
    }
}