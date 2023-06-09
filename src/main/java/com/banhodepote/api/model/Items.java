package com.banhodepote.api.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banhodepote.api.dto.ItemDTO;
import com.banhodepote.api.enums.CategoryFood;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="items")
public class Items {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private double price;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private List<Order> orders = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private CategoryFood categoryFood;

    public Items(ItemDTO data){
        this.itemName = data.itemName();
        this.price = data.price();
        this.categoryFood = CategoryFood.fromValue(data.categoryId());
    }

}
