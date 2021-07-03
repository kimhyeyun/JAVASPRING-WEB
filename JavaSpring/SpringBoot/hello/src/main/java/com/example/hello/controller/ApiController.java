package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 class 는 REST API를 처리하는 Controller
@RequestMapping("/api") // RequestMapping은 URI 를 지정해주는 Anotation
public class ApiController {
    
    @GetMapping("/hello") // http://localhost:8080/api/hello 가 매핑
    public String hello(){
        return "hello spring boot!";
    }
}
