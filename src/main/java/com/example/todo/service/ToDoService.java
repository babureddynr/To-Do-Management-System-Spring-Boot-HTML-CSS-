package com.example.todo.service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public Optional<ToDo> findById(Long id) {
        return toDoRepository.findById(id);
    }

    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }
}
