package com.example.TaskManager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TaskManager.model.Todo;

import com.example.TaskManager.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List < Todo > getTodosByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional < Todo > getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todoRepository.save(new Todo(name, desc, targetDate, isDone));
    }

    @Override
    public void deleteTodo(long id) {
        Optional < Todo > todo = todoRepository.findById(id); //Optional is a container class introduced in Java 8 to represent an optional value that may or may not be present. It helps avoid null pointer exceptions when working with potentially absent values.

        todoRepository.findById(id);// is a method call that is expected to return an Optional<Todo>. It means that it may return an instance of Todo if a todo with the specified id is found, or it may return an empty Optional if no such todo exists.
        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
        }
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
