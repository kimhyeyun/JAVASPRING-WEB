package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    // 현재 stopwatch가 메소드마다 같은 내용으로 들어가 있으므로 빼고, AOP로
    // 여기서는 서비스 로직만 처리해!

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
/*        StopWatch stopWatch = new StopWatch();
        stopWatch.start();*/

        // TODO

/*        System.out.println("get method");
        System.out.println("get method : " + id);
        System.out.println("get method : " + name);*/
        // AOP 를 이용하면 메소드마다 print 할 필요 없음
/*
        stopWatch.stop();
        System.out.println("total time : " +  stopWatch.getTotalTimeSeconds());*/

        return id + " " + name;
    }

    @Timer
    @PostMapping("/post")
    public User post(@RequestBody User user){/*
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // TODO

//        System.out.println("post method : " + user);

        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());*/

        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
/*        StopWatch stopWatch = new StopWatch();
        stopWatch.start();*/

        // db logic
        Thread.sleep(1000*2);
/*
        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());*/
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
