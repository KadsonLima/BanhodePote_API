package com.banhodepote.api.model;


import java.util.HashSet;
import java.util.Set;
import com.banhodepote.api.dto.ItemDTO;
import com.banhodepote.api.enums.CategoryFood;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="items")
public class Items {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String itemName;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private CategoryFood categoryFood;

    public Items(ItemDTO data){
        this.itemName = data.itemName();
        this.price = data.price();
        this.categoryFood = CategoryFood.fromValue(data.categoryId());
    }

}
