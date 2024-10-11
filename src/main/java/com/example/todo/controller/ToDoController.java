package com.example.todo.controller;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    // Get all To-Dos
    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.findAll();
    }

    // Create To-Do from form submission
    @PostMapping
    public ToDo createToDo(@RequestParam String title, @RequestParam(defaultValue = "false") boolean completed) {
        ToDo newToDo = new ToDo();
        newToDo.setTitle(title);
        newToDo.setCompleted(completed);
        return toDoService.save(newToDo);
    }

    // Get To-Do by ID
    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable Long id) {
        return toDoService.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
    }

    // Update To-Do
    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestParam String title, @RequestParam boolean completed) {
        ToDo toDo = toDoService.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        toDo.setTitle(title);
        toDo.setCompleted(completed);
        return toDoService.save(toDo);
    }

    // Delete To-Do
    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id) {
        toDoService.deleteById(id);
    }
}
