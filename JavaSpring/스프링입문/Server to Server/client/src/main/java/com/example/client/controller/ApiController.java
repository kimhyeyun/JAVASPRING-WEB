package com.example.client.controller;

import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ApiController {

    private RestTemplateService restTemplateService;

    @GetMapping("/hello")
    public UserResponse getHello(){
//        return restTemplateService.hello();
        restTemplateService.post();
        return new UserResponse();
    }

}
