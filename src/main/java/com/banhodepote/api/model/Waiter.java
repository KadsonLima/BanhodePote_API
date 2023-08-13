package com.banhodepote.api.model;
import java.util.ArrayList;
import java.util.List;
import com.banhodepote.api.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

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

    public void WaiterAuth(String email, String password){
        
    }

    @OneToMany(mappedBy = "waiter")
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();

    

   
}
