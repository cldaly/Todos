package com.cldaly.todos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cldaly.todos.model.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo,String> {

}
