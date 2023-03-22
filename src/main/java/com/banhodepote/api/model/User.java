package com.banhodepote.api.model;

import com.banhodepote.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Users")
abstract class User {

    protected User(UserDTO data){
        this.name = data.name();
        this.userName = data.user_name();
        this.password = data.password();
        this.email = data.email();
    
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String userName;
    
    @Column(length = 30, nullable = false)
    private String password;
    
    @Column(length = 30, nullable = false)
    private String email;
    
    @Column(length = 10, nullable = false)
    public String name;

   
}
