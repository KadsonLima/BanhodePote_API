package com.banhodepote.api.model;

import com.banhodepote.api.dto.UserDTO;

import jakarta.persistence.Entity;
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



    

   
}
