package com.cldaly.todos.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cldaly.todos.model.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo,String> {
	public ArrayList<Todo> findByDoneFalse();
	public ArrayList<Todo> findByDoneTrue();
}
