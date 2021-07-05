package com.example.springioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base64")
public class Base64Encoder implements IEncoder {

    public String encode(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
