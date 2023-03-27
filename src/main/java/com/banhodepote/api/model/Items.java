package com.banhodepote.api.model;


import java.util.ArrayList;
import java.util.List;

import com.banhodepote.api.enums.CategoryFood;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private CategoryFood categoryFood;
    
    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders = new ArrayList<>();
    

    public void CriarItem(){
        this.itemName = "COMIDA";
        this.price = 12;
        this.categoryFood = CategoryFood.PRATO;
    }
}
