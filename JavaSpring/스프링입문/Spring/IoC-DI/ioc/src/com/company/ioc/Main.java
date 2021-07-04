package com.company.ioc;

public class Main {

    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Base 64 encoding


        // url encoding


        IEncoder base64Encoder = new Base64Encoder();
        String result = base64Encoder.encode(url);

        IEncoder urlEncoder = new UrlEncoder();
        String urlresult = urlEncoder.encode(url);
        System.out.println(urlresult);

        // 딱히 ... 줄 지 않음

        Encoder encoder = new Encoder();
        result = encoder.encode(url);
        System.out.println(result);

        // Encoder 등을 건들필요 없이 가능~
        Encoder encoder1 = new Encoder(new Base64Encoder());
        result = encoder1.encode(url);
        System.out.println(result);
    }
}
