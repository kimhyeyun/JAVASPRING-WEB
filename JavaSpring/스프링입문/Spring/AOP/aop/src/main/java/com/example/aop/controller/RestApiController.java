package com.example.aop.controller;

import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
/*        System.out.println("get method");
        System.out.println("get method : " + id);
        System.out.println("get method : " + name);*/
        // AOP 를 이용하면 메소드마다 print 할 필요 없음

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
//        System.out.println("post method : " + user);
        return user;
    }
}
