package com.example.todoapi.controllers;

import com.example.todoapi.entities.Todo;
import com.example.todoapi.entities.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final TodoRepository todoRepository;

    public ToDoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }


    @GetMapping
    public List<Todo> getAllTodos(){
        return this.todoRepository.findAll();
    }

    @GetMapping("/{todoId}")
    public Optional<Todo> getTodo(@PathVariable("todoId") Long todoId){
        return this.todoRepository.findById(todoId);
    }


    @PostMapping
    public Todo newTodo(@RequestBody Todo todo){
        return this.todoRepository.save(todo) ;
    }

    @PutMapping("/editTodo/{todoId}")
    public Optional<Todo> editToDo(@PathVariable("todoId") Long todoId ,@RequestBody Todo updatedTodo){
return this.todoRepository.findById(todoId)
        .map(oldTodo -> this.todoRepository.save(updatedTodo));
    }

    @DeleteMapping("/deleteTodo/{todoId}")
    public void deleteToDo(@PathVariable("todoId") Long todoId) {
        this.todoRepository.deleteById(todoId);
    }

}
