package com.cldaly.todos.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cldaly.todos.model.Todo;
import com.cldaly.todos.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository tr;
	
	public Todo saveTodo(Todo todo) {
		todo.setDone(false);
		return tr.save(todo);
	}
	
	public Optional<Todo> findTodo(String id) {
		return tr.findById(id);
	}
	
	public ArrayList<Todo> findAllTodos(){
		return tr.findByDoneFalse();
	}
	
	public ArrayList<Todo> findAllCompleted(){
		return tr.findByDoneTrue();
	}
	
	public Todo completeTodo(String id) {
		Todo t = tr.findById(id).get();
		t.setDone(true);
		return tr.save(t);
	}
	
	public void deleteTodo(String id) {
		tr.deleteById(id);
	}
}
