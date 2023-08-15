package com.banhodepote.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.banhodepote.api.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JsonIgnoreProperties({"password", "userName"})
    @JoinColumn(name = "waiter")
    @JsonManagedReference
    private Waiter waiter;

    @ManyToMany
    @JoinTable(name = "order_item",
               joinColumns = @JoinColumn(name = "order_id"),
               inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Items> items = new HashSet<>();

    
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdAt = new Date();


    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Integer mesa;

    @Override
    public String toString() {
        return "Order(id=" + id + ", createdAt=" + createdAt + ", status=" + status + ")";
    } 
    
    public Order(Waiter waiter, Set<Items> items, int mesa) {
        this.waiter = waiter;
        this.items = items;
        this.status = Status.OPEN;
        this.mesa = mesa;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }



}
