package com.cldaly.todos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cldaly.todos.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository tr;
}
