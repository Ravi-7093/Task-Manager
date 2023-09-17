package com.example.TaskManager.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManager.model.Todo;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository < Todo, Long > {
    List < Todo > findByUserName(String user);
}