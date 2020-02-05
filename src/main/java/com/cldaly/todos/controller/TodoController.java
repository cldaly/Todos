package com.cldaly.todos.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cldaly.todos.model.Todo;
import com.cldaly.todos.service.TodoService;

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
	
	@PutMapping("/update/{id}")
	public Todo completeTodo(@PathVariable("id") String id) {
		return service.completeTodo(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTodo(@PathVariable("id") String id) {
		service.deleteTodo(id);
	}
}
