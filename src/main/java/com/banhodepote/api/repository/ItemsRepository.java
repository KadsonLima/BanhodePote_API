package com.banhodepote.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banhodepote.api.enums.CategoryFood;
import com.banhodepote.api.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {
    
    List<Items> findAll();
    List<Items> findByCategoryFood(CategoryFood categoryFood);
}
