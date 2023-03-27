package com.banhodepote.api.model;

import java.util.ArrayList;
import java.util.List;

import com.banhodepote.api.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Waiter extends User {

    public Waiter(UserDTO data){
        super();
        setEmail(data.email());
        setName(data.name());
        setUserName(data.user_name());
        setPassword(data.password());
    }

    @OneToMany(mappedBy = "waiter")
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();

    

   
}
