package com.example.todolist.controller;

import com.example.todolist.model.todoEntity;
import com.example.todolist.model.todoReq;
import com.example.todolist.model.todoRes;
import com.example.todolist.service.todoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/")
@RestController
public class todoController {

    private final todoService service;

    @PostMapping
    public ResponseEntity<todoRes> create(@RequestBody todoReq req){
        System.out.println("CREATE");

        if(ObjectUtils.isEmpty(req.getTitle()))
            return ResponseEntity.badRequest().build();
        if(ObjectUtils.isEmpty(req.getOrder()))
            req.setOrder(0L);
        if(ObjectUtils.isEmpty(req.getCompleted()))
            req.setCompleted(false);

        todoEntity result = this.service.add(req);

        return ResponseEntity.ok(new todoRes(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<todoRes> readOne(@PathVariable Long id){
        System.out.println("READ ONE");
        todoEntity result = this.service.searchById(id);
        return ResponseEntity.ok(new todoRes(result));
    }

    @GetMapping
    public ResponseEntity<List<todoRes>> readAll(){
        System.out.println("READ ALL");
        List<todoEntity> list = this.service.searchAll();
        List<todoRes> res = list.stream().map(todoRes::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    @PatchMapping("{id}")
    public ResponseEntity<todoRes> update(@PathVariable Long id, @RequestBody todoReq req){
        System.out.println("UPDATE");
        todoEntity result = this.service.updateById(id, req);
        return ResponseEntity.ok(new todoRes(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        System.out.println("DELETE");
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        System.out.println("DELETE ALL");
        this.service.deleteAll();
        return ResponseEntity.ok().build();
    }

}
