package com.example.todolist.repository;

import com.example.todolist.model.todoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todoRepository extends JpaRepository<todoEntity, Long> {
}
