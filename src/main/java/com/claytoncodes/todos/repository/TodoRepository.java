package com.claytoncodes.todos.repository;

import com.claytoncodes.todos.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    ArrayList<Todo> findByDoneFalse();
    ArrayList<Todo> findByDoneTrue();
}
