package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")    // http://localhost:8080/api/get/hello
    public String Hello(){
        return "get Hello";
    }

    // 예전 방식
    /*@RequestMapping("/hi")  // get / post / put / delete 모두 Mapping*/
    @RequestMapping(path = "/hi", method = RequestMethod.GET)   // get http://localhost:8080/api/get/hi
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get 여기까지는 고정
    // http://localhost:8080/api/get/path-variable/{name} // name을 받아야 함 (변화함)
/*    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : "+name);
        return name;
    }*/

    // Path 상의 이름과 변수 이름이 다를 때
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable : "+pathName);
        return pathName;
    }


    // ?key=value?key2=value2...~~~

    //http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(
                entry->{
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                    System.out.println("\n");

                    sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
                }
        );

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email+ " " + age;

    }

    // 객체로 전달받기
    // 객체에 없는 값은 매핑되지 않음
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();

    }
}
