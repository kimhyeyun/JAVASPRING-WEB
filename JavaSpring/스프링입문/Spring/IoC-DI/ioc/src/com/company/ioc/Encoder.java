package com.company.ioc;

import java.util.Base64;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public Encoder(){
        this.iEncoder = new Base64Encoder();
    }

    public String encode(String msg){
        return iEncoder.encode(msg);
    }
}
