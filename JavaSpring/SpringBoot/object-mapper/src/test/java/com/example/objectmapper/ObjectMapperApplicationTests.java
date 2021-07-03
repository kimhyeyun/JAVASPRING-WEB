package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("------------");

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req Json(text) -> object
        // response object -> Json(text)

        var ObjectMapper = new ObjectMapper();

        // object -> text
        // object mapper는 get method를 활용

        // error! object getter/setter 만 취급
        var user = new User("steve",10, "010-1111-2222");
        var text = ObjectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper는 default 생성자를 필요로 함

        // error! default 생성자가 필요!
        var objectUser = ObjectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
