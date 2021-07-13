package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
//                    HttpEntity<String> entity,
                    @RequestBody Req<User> user,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorization,
                     @RequestHeader("custom-header") String customHeader
    ){
//        log.info("entity : {}", entity);
        log.info("client req : {}", user);
        log.info("userId : {}, userName: {}", userId, userName);
        log.info("authorization : {}, customHeader : {} ", authorization, customHeader);

        Req<User> res = new Req<>();
        res.setHeader(new Req.Header());
        res.setResBody(user.getResBody());

        return res;
    }
}
