package com.cc.users.infrastructure.input.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping
    public String helloworld(){
        return "hi";
    }
}
