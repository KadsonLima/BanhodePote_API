package com.banhodepote.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banhodepote.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
