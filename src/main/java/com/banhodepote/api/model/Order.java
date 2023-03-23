package com.banhodepote.api.model;

import java.util.Date;

import com.banhodepote.api.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private Waiter waiter;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items items;
    
    @Column(nullable = false)
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;
}
