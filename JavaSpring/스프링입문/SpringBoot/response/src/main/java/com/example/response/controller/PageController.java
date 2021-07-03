package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    // 200 ok
    // main.html Return
    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }


    // ResponseEntity

    // 사용 x
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();

        user.setName("steve");
        user.setAddress("here");

        return user;

    }
}
