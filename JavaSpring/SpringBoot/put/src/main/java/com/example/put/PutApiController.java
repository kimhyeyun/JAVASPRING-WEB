package com.example.put;

import com.example.put.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public void put(@RequestBody PostRequestDTO postRequestDTO){
        System.out.println(postRequestDTO);
    }

    @PutMapping("/put/{userid}")
    public PostRequestDTO put(@RequestBody PostRequestDTO requestDTO, @PathVariable Long userid){
        System.out.println(userid);
        return requestDTO;
    }
}
