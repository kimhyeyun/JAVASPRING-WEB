package com.example.todolist.service;

import com.example.todolist.model.todoEntity;
import com.example.todolist.model.todoReq;
import com.example.todolist.repository.todoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class todoService {

    private  final todoRepository todoRepository;

    public todoEntity add(todoReq request){
        todoEntity todoEntity = new todoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoEntity);
    }

    public todoEntity searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<todoEntity> searchAll(){
        return this.todoRepository.findAll();
    }

    public todoEntity updateById(Long id, todoReq request){
        todoEntity todoEntity = this.searchById(id);
        if(request.getTitle() != null){
            todoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null){
            todoEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null){
            todoEntity.setCompleted(request.getCompleted());
        }

        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    public void deleteAll(){
        this.todoRepository.deleteAll();
    }

}
