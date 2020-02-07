package com.cldaly.todos.service;

import com.cldaly.todos.model.Todo;
import com.cldaly.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository tr;

    public Todo saveTodo(Todo todo) {
        todo.setDone(false);
        return tr.save(todo);
    }

    public ArrayList<Todo> findAllTodos(){
        return tr.findByDoneFalse();
    }

    public ArrayList<Todo> findAllCompleted(){
        return tr.findByDoneTrue();
    }

    public Todo completeTodo(String id) {
        Optional<Todo> todo = tr.findById(id);
        if (todo.isPresent()) {
            Todo t = todo.get();
            t.setDone(true);
            return tr.save(t);
        } else {
            return null;
        }
    }

    public void deleteTodo(String id) {
        tr.deleteById(id);
    }
}
