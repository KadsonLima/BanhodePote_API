package com.banhodepote.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhodepote.api.dto.UserDTO;
import com.banhodepote.api.model.User;
import com.banhodepote.api.repository.UserRepository;

@RestController
@RequestMapping("/vida")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> helloMundo(){
        return repository.findAll();
    }

    @PostMapping
    public void helloMundo2(@RequestBody UserDTO req){

        repository.save(new User(req));
    }
}
