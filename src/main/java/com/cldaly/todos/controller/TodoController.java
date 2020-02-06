package com.cldaly.todos.controller;

import com.cldaly.todos.model.Todo;
import com.cldaly.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public ArrayList<Todo> getTodos(){
        return service.findAllTodos();
    }

    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo) {
        return service.saveTodo(todo);
    }

    @GetMapping("/completed")
    public ArrayList<Todo> getCompletedTodos(){
        return service.findAllCompleted();
    }

    @PutMapping("/update")
    public Todo completeTodo(@RequestBody String id) {
        return service.completeTodo(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable("id") String id) {
        service.deleteTodo(id);
    }
}
