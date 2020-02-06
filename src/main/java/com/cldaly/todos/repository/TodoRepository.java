package com.cldaly.todos.repository;

import com.cldaly.todos.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    public ArrayList<Todo> findByDoneFalse();
    public ArrayList<Todo> findByDoneTrue();
}
