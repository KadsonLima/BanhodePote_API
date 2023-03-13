package com.banhodepote.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vida")
public class UserController {

    @GetMapping
    public String helloMundo(){
        return "String";
    }

    @GetMapping("/cacha")
    public String helloMundo2(){
        return "hello";
    }
}
